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
        <ion-button expand="block" class="check-availability-button" @click="checkAvailability">Check Availability</ion-button>
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
        <MessageListItem v-for="room in roomStore.allRooms" :key="room.id" :room="room" />
      </ion-list>
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
  IonBackButton, IonButton
} from '@ionic/vue';
import MessageListItem from '@/components/RoomListItem.vue';
import { onMounted, ref } from 'vue';
import VueDatePicker from "@vuepic/vue-datepicker";
import '@vuepic/vue-datepicker/dist/main.css'
import { useRoomStore } from '@/roomStore';


const rooms = ref<Array<any> | null>(null);
  const roomStore=useRoomStore()

const date = ref();

const fetchData = async () => {
  await roomStore.fetchAllRooms();
};

const checkAvailability = async () => {
  if (date.value[0] && date.value[1]) {
    await roomStore.checkAvailability(
      date.value[0].toISOString().split('T')[0],
      date.value[1].toISOString().split('T')[0]
    );
  } else {
    console.log('Please select a date range.');
  }
}

onMounted(() => {
  fetchData()
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

</style>