<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button default-href="/"></ion-back-button>
        </ion-buttons>
        <ion-title>Rooms</ion-title>
      </ion-toolbar>
      </ion-toolbar>
    </ion-header>
    <ion-content :fullscreen="true">
      <div class="date-picker-container">
        <VueDatePicker
            v-model="date"
            min-date="new Date()"
            :enable-time-picker="false"
            range
        />
        <ion-button expand="block" class="check-availability-button" @click="checkAvailability">Check Availability
        </ion-button>
      </div>
      <ion-refresher slot="fixed" @ionRefresh="refresh($event)">
        <ion-refresher-content></ion-refresher-content>
      </ion-refresher>

      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Rooms</ion-title>
        </ion-toolbar>
      </ion-header>

      <ion-list>
        <MessageListItem v-for="room in roomStore.allRooms" :key="room.id" :room="room" :check-in="formattedDate(date[0])" :check-out="formattedDate(date[1], true)" />
      </ion-list>
      <div v-if="!roomStore.allRooms.length" class="error-card-container">
        <ion-card class="error-card">
          <ion-card-header>
            <ion-icon class="error-icon" :icon="closeCircleOutline"></ion-icon>
          </ion-card-header>
          <ion-card-content>
            There are no available Rooms for the given dates. Please enter
            different Dates or come back on another day.
          </ion-card-content>
        </ion-card>
      </div>
      <div v-if="roomStore.allRooms.length">
        <ion-list>
          <MessageListItem
            v-for="room in roomStore.allRooms"
            :key="room.id"
            :room="room"
          />
        </ion-list>
        <div class="pagination-container">
          <div
            v-for="page in roomStore.allRoomsMetaDeta?.totalPages"
            :class="
              roomStore.currentPage === page ? 'page selected-page' : 'page'
            "
            @click="() => updateData(page)"
          >
            {{ page }}
          </div>
        </div>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonContent,
  IonHeader,
  IonList,
  IonPage,
  IonRefresher,
  IonRefresherContent,
  IonTitle,
  IonToolbar,
  IonButtons,
  IonBackButton,
  IonButton,
  IonCard,
  IonCardContent,
  IonCardHeader,
} from "@ionic/vue";
import MessageListItem from '@/components/RoomListItem.vue';
import {onMounted, ref} from 'vue';
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";
import { useRoomStore } from "@/roomStore";
import { closeCircleOutline } from "ionicons/icons";

const roomStore = useRoomStore();
const date = ref();

const fetchData = async () => {
  await roomStore.fetchAllRooms();
};

const updateData = (page: number) => {
  roomStore.setCurrentPage(page);
  fetchData();
}
  const formattedDate = (date, isCheckout = false) => {
    if (!date) return '';
    const d = new Date(date);
    const day = String(d.getDate()).padStart(2, '0');
    const month = String(d.getMonth() + 1).padStart(2, '0');
    const year = d.getFullYear();
    const hour = isCheckout ? '23' : '00';
    const minute = isCheckout ? '59' : '00';
    return `${year}-${month}-${day}T${hour}:${minute}`;
  };

const checkAvailability = async () => {
  if (date.value[0] && date.value[1]) {
    await roomStore.checkAvailability(
      date.value[0].toISOString().split("T")[0],
      date.value[1].toISOString().split("T")[0]
    );
  } else {
    console.log("Please select a date range.");
  }
};

  onMounted(() => {
    fetchData();
    const startDate = new Date();
    const endDate = new Date(new Date().setDate(startDate.getDate() + 7));
    date.value = [startDate, endDate];
  });

  const refresh = (ev: CustomEvent) => {
    setTimeout(() => {
      ev.detail.complete();
    }, 3000);
  };

</script>

<style scoped>
.date-picker-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 20px auto;
  max-width: 500px;
  width: 100%;
}
.check-availability-button {
  margin-top: 10px;
}

.pagination-container {
  display: flex;
  justify-content: center;
}
.error-card-container {
  display: flex;
  justify-content: center;
}
.error-card {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 200px;
  width: 40%;
  height: 30%;
}
.page {
  width: 20px;
  border: 0.5px solid saddlebrown;
  padding-left: 5px;
  margin: 2px;
}
.selected-page {
  background-color: saddlebrown;
  color: white;
}
.error-icon {
  color: saddlebrown;
  font-size: 18px!important;
  height: 100px;
  width: 100px;
}
</style>


