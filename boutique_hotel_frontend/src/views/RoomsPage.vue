<template>
  <ion-page>
    <ion-content :fullscreen="true">
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-buttons slot="start">
            <ion-back-button :text="getBackButtonText()" default-href="/"></ion-back-button>
          </ion-buttons>
          <ion-title>Rooms</ion-title>
        </ion-toolbar>
      </ion-header>

      <ion-spinner v-if="loading" name="crescent"></ion-spinner>
      <div v-if="!loading">
        <div class="date-picker-container">
          <VueDatePicker v-model="date" :min-date="new Date()" :enable-time-picker="false" range />
          <ion-button expand="block" class="check-availability-button" @click="checkAvailability">
            Check Availability
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
          <MessageListItem
              v-for="room in roomStore.allRooms"
              :key="room.id"
              :room="room"
              :check-in="formattedDate(date[0])"
              :check-out="formattedDate(date[1], true)"
          />
        </ion-list>
        <div v-if="!roomStore.allRooms.length" class="error-card-container">
          <ion-card class="error-card">
            <ion-card-header>
              <ion-icon class="error-icon" :icon="closeCircleOutline"></ion-icon>
            </ion-card-header>
            <ion-card-content>
              There are no available Rooms for the given dates. Please enter different Dates or come back on another day.
            </ion-card-content>
          </ion-card>
        </div>

        <div class="pagination-container" v-if="roomStore.allRooms.length">
          <div
              v-for="page in roomStore.allRoomsMetaDeta?.totalPages"
              :class="roomStore.currentPage === (page + 1) ? 'page selected-page' : 'page'"
              @click="updateData(page + 1)"
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
  IonSpinner,
} from "@ionic/vue";
import MessageListItem from '@/components/RoomListItem.vue';
import { onMounted, ref, computed } from 'vue';
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";
import { useRoomStore } from "@/roomStore";
import { closeCircleOutline } from "ionicons/icons";

const roomStore = useRoomStore();
const date = ref([new Date(), new Date(new Date().setDate(new Date().getDate() + 7))]);
const loading = computed(() => roomStore.loading);

const fetchData = async () => {
  roomStore.loading = true;
  await roomStore.fetchAllRooms();
};

const updateData = async (page: number) => {
  roomStore.loading = true;
  await roomStore.updateData(page);
};

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
    roomStore.loading = true;
    await roomStore.checkAvailability(
        date.value[0].toISOString().split("T")[0],
        date.value[1].toISOString().split("T")[0]
    );
    roomStore.loading = false;
  } else {
    console.log("Please select a date range.");
  }
};
const getBackButtonText = () => {
  const win = window as any;
  const mode = win && win.Ionic && win.Ionic.mode;
  return mode === 'ios' ? 'Inbox' : '';
};
onMounted(() => {
  fetchData();
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
  cursor: pointer;
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
