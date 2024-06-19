<template>
  <ion-page>
    <ion-content :fullscreen="true">
      <ion-header :translucent="true">
        <ion-toolbar>
          <ion-buttons slot="start">
            <ion-back-button :default-href="`/reservation/${roomId}`"></ion-back-button>
          </ion-buttons>
          <ion-title>Review Reservation</ion-title>
        </ion-toolbar>
      </ion-header>

      <ion-spinner v-if="loading" name="crescent"></ion-spinner>
      <div v-if="!loading">
        <ion-list>
          <ion-item>
            <ion-label>First Name:</ion-label>
            <ion-text>{{ firstName }}</ion-text>
          </ion-item>
          <ion-item>
            <ion-label>Last Name:</ion-label>
            <ion-text>{{ lastName }}</ion-text>
          </ion-item>
          <ion-item>
            <ion-label>Email:</ion-label>
            <ion-text>{{ email }}</ion-text>
          </ion-item>
          <ion-item>
            <ion-label>Breakfast:</ion-label>
            <ion-text>{{ breakfast ? 'Yes' : 'No' }}</ion-text>
          </ion-item>
          <ion-item>
            <ion-label>Check In:</ion-label>
            <ion-text>{{ checkIn }}</ion-text>
          </ion-item>
          <ion-item>
            <ion-label>Check Out:</ion-label>
            <ion-text>{{ checkOut }}</ion-text>
          </ion-item>
          <ion-item>
            <ion-label>Room:</ion-label>
            <ion-text>{{ roomTitle }} ({{ roomPrice }})</ion-text>
          </ion-item>
        </ion-list>
        <ion-button expand="block" @click="submitReservation">Confirm Reservation</ion-button>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonBackButton,
  IonButtons,
  IonContent,
  IonHeader,
  IonItem,
  IonLabel,
  IonList,
  IonPage,
  IonText,
  IonTitle,
  IonToolbar,
  IonButton,
  IonSpinner,
} from '@ionic/vue';
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const roomId = ref(route.query.roomId);
const firstName = ref(route.query.firstName);
const lastName = ref(route.query.lastName);
const email = ref(route.query.email);
const breakfast = ref(route.query.breakfast === 'true');  // Convert string to boolean
const checkIn = ref(route.query.checkIn);
const checkOut = ref(route.query.checkOut);
const roomTitle = ref(route.query.roomTitle);
const roomPrice = ref(route.query.roomPrice);
const loading = ref(false);
const roomDetails = ref(null);

onMounted(async () => {
  await fetchRoomDetails();
  console.log('Parameters received:');
  console.log('roomId:', roomId.value);
  console.log('firstName:', firstName.value);
  console.log('lastName:', lastName.value);
  console.log('email:', email.value);
  console.log('breakfast:', breakfast.value);
  console.log('checkIn:', checkIn.value);
  console.log('checkOut:', checkOut.value);
  console.log('roomTitle:', roomTitle.value);
  console.log('roomPrice:', roomPrice.value);
});

const fetchRoomDetails = async () => {
  loading.value = true;
  try {
    const response = await axios.get(`http://localhost:8001/rooms/${roomId.value}`);
    const data = response.data;
    data.images = JSON.parse(data.images);
    roomDetails.value = data;
  } catch (error) {
    console.error('Error fetching room details:', error);
  } finally {
    loading.value = false;
  }
};

const submitReservation = async () => {
  loading.value = true;
  try {
    await axios.post('http://localhost:8001/reservations', {
      first_name: firstName.value,
      last_name: lastName.value,
      email: email.value,
      breakfast: breakfast.value,
      room: { id: roomId.value },
      checkIn: checkIn.value,
      checkOut: checkOut.value
    });

    router.push({
      name: 'ConfirmReservation',
      query: {
        firstName: firstName.value,
        lastName: lastName.value,
        email: email.value,
        breakfast: breakfast.value ? 'true' : 'false',
        checkIn: checkIn.value,
        checkOut: checkOut.value,
        roomTitle: roomDetails.value.title,
        roomPrice: roomDetails.value.price,
        roomExtras: roomDetails.value.extras,
        roomDescription: roomDetails.value.description,
        roomImage: roomDetails.value.images[0],
        roomImageTwo: roomDetails.value.images[1],
      }
    });
  } catch (error) {
    console.error('Error making reservation:', error);
    alert('Failed to make reservation');
  } finally {
    loading.value = false;
  }
};
</script>

<style scoped>
ion-item {
  margin-bottom: 16px;
}
</style>
