<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Home</ion-title>
      </ion-toolbar>
      <ion-button :routerLink="'/rooms/'"  >Go to hotel rooms</ion-button>
    </ion-header>

        <img src="https://www.hotel-outside.at/fileadmin/_processed_/c/8/csm_hotelansicht-winter_706409aa0e.jpg" alt="Hotel Image" />
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonContent,
  IonHeader,
  IonPage,
  IonTitle,
  IonToolbar,
  IonButton
} from '@ionic/vue';
import { link } from 'ionicons/icons';


</script>
