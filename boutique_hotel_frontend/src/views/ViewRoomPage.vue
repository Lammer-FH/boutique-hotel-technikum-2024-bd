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
          <div class="image-wrapper">
            <ion-icon @click="prevImage" :class="currentImageIndex === 0 && 'disabled-icon'"  :icon="chevronBackOutline"></ion-icon>
            <img :src="currentImage" alt="Hotel Room Image" class="room-images" />
              <ion-icon  @click="nextImage" :icon="chevronForwardOutline" :class="singleRoom.images.length-1 === currentImageIndex && 'disabled-icon'"></ion-icon>
          </div>
          <h3>Beds: <ion-note>{{ singleRoom?.bedcount }}</ion-note></h3>
        </ion-label>
      </ion-item>

      <div class="ion-padding">
        <h3>{{ singleRoom?.extras }}</h3>
        <p>{{ singleRoom?.description }}</p>
      </div>
      <ion-button class="check-availability-button" expand="block" @click="navigateToReservation">Reserve Room</ion-button>
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
import { chevronBackOutline, chevronForwardOutline } from 'ionicons/icons';
import { computed,ref, onBeforeMount } from 'vue';
import { useRoomStore } from '@/roomStore';

const getBackButtonText = () => {
  const win = window as any;
  const mode = win && win.Ionic && win.Ionic.mode;
  return mode === 'ios' ? 'Inbox' : '';
};

import router from "@/router";
const route = useRoute();
const currentImageIndex = ref(0);
const roomStore= useRoomStore();

const navigateToReservation = () => {
  if (singleRoom.value && singleRoom.value.id) {
    console.log('Navigating to reservation page for room:', singleRoom.value.id);
    router.push(`/reservation/${singleRoom.value.id}`);
  } else {
    console.error('Room ID is not available');
  }
};


const fetchRoomData = async () => {
  const roomId = route.params.id as string;
  await roomStore.fetchRoomData(roomId);
};

onBeforeMount(async () => {
  await fetchRoomData(); 
});
const currentImage = computed(() => {
  return singleRoom.value?.images?.[currentImageIndex.value];
});

const nextImage = () => {
  if (currentImageIndex.value < singleRoom.value?.images?.length! - 1) {
    currentImageIndex.value++;
  }
};

const prevImage = () => {
  if (currentImageIndex.value > 0) {
    currentImageIndex.value--;
  }
};


const singleRoom = computed(() => roomStore.singleRoom);


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

.check-availability-button{
  width: 100%;
  max-width: 500px;
  margin: 10px auto;

}

p {
  line-height: 1.4;
}

.image-wrapper{
  display: flex;
  align-items: center;
justify-content:center;
}

.room-images{
  width: 500px;
  height: 300px;
}


.icons{
  position: absolute;
  z-index: 1000;

}

.disabled-icon{
opacity: 0.5;}
</style>
