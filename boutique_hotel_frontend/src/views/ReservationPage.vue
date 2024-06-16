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
      <form @submit.prevent="goToPreview">
        <ion-item>
          <ion-label position="floating">First Name</ion-label>
          <ion-input v-model="firstName" required></ion-input>
        </ion-item>

        <ion-item>
          <ion-label position="floating">Last Name</ion-label>
          <ion-input v-model="lastName" required></ion-input>
        </ion-item>

        <ion-item>
          <ion-label position="floating">Email</ion-label>
          <ion-input v-model="email" type="email" required></ion-input>
        </ion-item>

        <ion-item>
          <ion-label position="floating">Confirm Email</ion-label>
          <ion-input v-model="confirmEmail" type="email" required></ion-input>
        </ion-item>

        <ion-item>
          <ion-label>Breakfast</ion-label>
          <ion-checkbox v-model="breakfast"></ion-checkbox>
        </ion-item>

        <div class="date-picker">
        <ion-item>
          <ion-datetime  v-model="checkIn" presentation="date" :min=minDate><span slot="title"> Check In</span> </ion-datetime>
        </ion-item>
        <ion-item>
          <ion-datetime presentation="date" :min=checkIn v-model="checkOut"><span slot="title"> Check Out</span> </ion-datetime>
        </ion-item>
        </div>

        <ion-button expand="block" type="submit">Preview Reservation</ion-button>
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
  IonDatetime,
  IonHeader,
  IonInput,
  IonItem,
  IonLabel,
  IonPage,
  IonTitle,
  IonToolbar,
  IonButton
} from '@ionic/vue';
import { computed, onBeforeMount, onMounted, ref } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useRoomStore } from '@/roomStore';

const route = useRoute();
const router = useRouter();
const roomId = route.params.id;
const roomStore= useRoomStore()

const room = ref<any>(null);
const firstName = ref('');
const lastName = ref('');
const email = ref('');
const confirmEmail = ref('');
const breakfast = ref(false);
const checkIn = ref(new Date().toISOString());
const checkOut = ref(new Date().toISOString());
const minDate = new Date().toISOString();
const singleRoom = computed(() => roomStore.singleRoom);


const goToPreview = () => {
  if (email.value !== confirmEmail.value) {
    alert('Emails do not match');
    return;
  }

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
  fetchRoomData()
});

</script>

<style scoped>
ion-item {
  margin-bottom: 16px;
}

.date-picker {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  margin: 20px auto;
}
</style>
