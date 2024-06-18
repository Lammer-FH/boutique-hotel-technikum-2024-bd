<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-buttons slot="start">
          <ion-back-button default-href="/"></ion-back-button>
        </ion-buttons>
        <ion-title>Reserve {{ singleRoom?.title }}</ion-title>
      </ion-toolbar>
    </ion-header>

    <ion-content :fullscreen="true">
      <form @submit.prevent="goToPreview" class="reservation-form">
        <ion-item class="input-item">
          <ion-label position="floating">First Name</ion-label>
          <ion-input v-model="firstName" required></ion-input>
        </ion-item>

        <ion-item class="input-item">
          <ion-label position="floating">Last Name</ion-label>
          <ion-input v-model="lastName" required></ion-input>
        </ion-item>

        <ion-item class="input-item">
          <ion-label position="floating">Email</ion-label>
          <ion-input v-model="email" type="email" required></ion-input>
        </ion-item>

        <ion-item class="input-item">
          <ion-label>Breakfast</ion-label>
          <ion-checkbox v-model="breakfast"></ion-checkbox>
        </ion-item>


        <ion-button expand="block" type="submit" class="submit-button">Preview Reservation</ion-button>
      </form>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonBackButton,
  IonButtons,
  IonCheckbox,
  IonContent,
  IonHeader,
  IonInput,
  IonItem,
  IonLabel,
  IonPage,
  IonTitle,
  IonToolbar,
  IonButton
} from '@ionic/vue';
import { computed, onBeforeMount, ref } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useRoomStore } from '@/roomStore';

const route = useRoute();
const router = useRouter();
const roomId = route.params.id;
const roomStore = useRoomStore();

const firstName = ref('');
const lastName = ref('');
const email = ref('');
const breakfast = ref(false);
const checkIn = ref(route.query.checkIn);
const checkOut = ref(route.query.checkOut);
const singleRoom = computed(() => roomStore.singleRoom);

const goToPreview = () => {
  router.push({
    name: 'PreviewReservation',
    query: {
      roomId: roomId.toString(),
      firstName: firstName.value,
      lastName: lastName.value,
      email: email.value,
      breakfast: breakfast.value ? 'true' : 'false',
      checkIn: checkIn.value,
      checkOut: checkOut.value,
      roomTitle: singleRoom.value?.title,
      roomPrice: singleRoom.value?.price.toString()
    }
  });
};
const fetchRoomData = async () => {
  await roomStore.fetchRoomData(roomId as string);
};

onBeforeMount(async () => {
  fetchRoomData();
});
</script>

<style scoped>
ion-item {
  margin-bottom: 16px;
}

.reservation-form {
  display: flex;
  flex-direction: column;
  padding: 16px;
}

.input-item {
  --highlight-color-focused: #3880ff;
  --highlight-color: #ccc;
  padding: 8px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.submit-button {
  margin-top: 20px;
}
</style>
