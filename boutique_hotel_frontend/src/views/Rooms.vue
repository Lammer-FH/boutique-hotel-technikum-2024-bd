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
      <ion-refresher slot="fixed" @ionRefresh="refresh($event)">
        <ion-refresher-content></ion-refresher-content>
      </ion-refresher>

      <ion-header collapse="condense">
        <ion-toolbar>
          <ion-title size="large">Rooms</ion-title>
        </ion-toolbar>
      </ion-header>

      <ion-list>
        <MessageListItem v-for="room in rooms" :key="room.id" :room="room" />
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
  IonBackButton
} from '@ionic/vue';
import MessageListItem from '@/components/RoomListItem.vue';
import { onMounted, ref } from 'vue';
import axios from 'axios';


const rooms = ref<Array<any> | null>(null);

const fetchData = async () => {
  try {
    console.log("in fetch dta")
    const response = await axios.get('http://localhost:8001/api/rooms');
    rooms.value = response.data;
    console.log(response.data)
  } catch (error) {
    console.error('Error fetching data:', error);
  }
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
