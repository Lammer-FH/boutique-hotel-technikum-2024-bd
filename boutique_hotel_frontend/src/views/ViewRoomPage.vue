<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button :text="getBackButtonText()" default-href="/"></ion-back-button>
        </ion-buttons>
        <ion-title>{{ singleRoom?.title }}</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true" v-if="singleRoom">
      <ion-item>
        <ion-label class="ion-text-wrap">
          <h2>
            {{ singleRoom?.title }}
            <span class="price">
              <ion-note>${{ singleRoom?.price }}</ion-note>
            </span>
          </h2>
          <div v-for="(image, index) in singleRoom?.images" :key="index">
            <img :src="image" alt="Hotel Room Image" />
          </div>
          <h3>Beds: <ion-note>{{ singleRoom?.bedcount }}</ion-note></h3>
        </ion-label>
      </ion-item>

      <div class="ion-padding">
        <h3>{{ singleRoom?.extras }}</h3>
        <p>{{ singleRoom?.description }}</p>
      </div>
      <ion-button expand="block" @click="navigateToReservation">Reserve Room</ion-button>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import { useRoute } from 'vue-router';
import {
  IonBackButton,
  IonButtons,
  IonContent,
  IonHeader,
  IonIcon,
  IonItem,
  IonLabel,
  IonNote,
  IonPage,
  IonToolbar,
} from '@ionic/vue';
import { onMounted, ref } from 'vue';
import axios from 'axios';

const getBackButtonText = () => {
  const win = window as any;
  const mode = win && win.Ionic && win.Ionic.mode;
  return mode === 'ios' ? 'Inbox' : '';
};

import router from "@/router";
const route = useRoute();
// const room = {id:parseInt(route.params.id as string, 10), title: "roomTitle", price: "3$", bedcount:2, extra:"extra", description:"This s a room "};
const singleRoom = ref<any>(null);
const navigateToReservation = () => {
  if (singleRoom.value && singleRoom.value.id) {
    console.log('Navigating to reservation page for room:', singleRoom.value.id);
    router.push(`/reservation/${singleRoom.value.id}`);
  } else {
    console.error('Room ID is not available');
  }
};

const fetchData = async () => {
  try {
    console.log("in fetch dta")
    console.log("Fetching data for room:", route.params.id);
    const response = await axios.get(`http://localhost:8001/rooms/${route.params.id}`);
    const roomData = response.data;
    roomData.images = JSON.parse(roomData.images); // Konvertiere JSON-String in Array image geht noch nicht
    singleRoom.value = roomData;
    console.log('Fetched room data:', singleRoom.value);
    console.log(response.data)
  } catch (error) {
    console.error('Error fetching data:', error);
  }
};

onMounted(() => {
  fetchData();
});


</script>

<style scoped>
ion-item {
  --inner-padding-end: 0;
  --background: transparent;
}

ion-label {
  margin-top: 12px;
  margin-bottom: 12px;
}

ion-item h2 {
  font-weight: 600;
  
  /**
   * With larger font scales
   * the date/time should wrap to the next
   * line. However, there should be
   * space between the name and the date/time
   * if they can appear on the same line.
   */
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

ion-item .date {
  align-items: center;
  display: flex;
}

ion-item ion-icon {
  font-size: 42px;
  margin-right: 8px;
}

ion-item ion-note {
  font-size: 0.9375rem;
  margin-right: 12px;
  font-weight: normal;
}

h1 {
  margin: 0;
  font-weight: bold;
  font-size: 1.4rem;
}

p {
  line-height: 1.4;
}
</style>
