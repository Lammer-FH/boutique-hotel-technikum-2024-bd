<template>
  <ion-page>
    <ion-content :fullscreen="true">
      <ion-header :translucent="true">
        <ion-toolbar class="header-toolbar">
          <ion-title>Your Booking has been confirmed</ion-title>
          <ion-title class="sub-title">Booking Information</ion-title>
        </ion-toolbar>
      </ion-header>

      <div class="confirmation-content">
        <div class="booking-details">
          <div class="detail-item">
            <label>First Name:</label>
            <span>{{ reservation.firstName }}</span>
          </div>
          <div class="detail-item">
            <label>Check In:</label>
            <span>{{ reservation.checkIn }}</span>
          </div>
          <div class="detail-item">
            <label>Last Name:</label>
            <span>{{ reservation.lastName }}</span>
          </div>
          <div class="detail-item">
            <label>Check Out:</label>
            <span>{{ reservation.checkOut }}</span>
          </div>
          <div class="detail-item">
            <label>Email:</label>
            <span>{{ reservation.email }}</span>
          </div>
          <div class="detail-item">
            <label>Breakfast:</label>
            <span>{{ reservation.breakfast ? 'Yes' : 'No' }}</span>
          </div>

          <div class="detail-item">
            <label>Room:</label>
            <span>{{ reservation.roomTitle }} ({{ reservation.roomPrice }})</span>
          </div>
          <div class="detail-item">
            <label>Room Extras:</label>
            <span>{{ reservation.roomExtras }}</span>
          </div>
          <div class="detail-item">
            <label>Room Description:</label>
            <span>{{ reservation.roomDescription }}</span>
          </div>
        </div>
        <div class="room-images">
          <img
              :src="reservation.roomImage"
              alt="Hotel Room Image"
              class="room-image"
          />
          <img
              :src="reservation.roomImageTwo"
              alt="Hotel Room Image"
              class="room-image"
          />
        </div>
        <div class="hotel-info">
          <h3>Hotel Address</h3>
          <p>Höchstädtpl. 6, 1200 Wien</p>
          <h3>Contact Information</h3>
          <p>Group BD <br>
            technikum-wien@gmail.com <br>
            Tel.: +436761234567 </p>
          <h3>Transportation Information</h3>
          <p>Nearest Train Station: Dresdner Straße (U6), Traisengasse <br>
            Bus Lines: 37A (Höchstädtplatz), 31A (Heinrich-von-Buol-Gasse), 11A, 11B (Vorgartenstraße)<br>
            Tram Lines: 2, 31, 33 (Höchstädtplatz)</p>
        </div>
        <ion-button expand="block" @click="printPage">Print Confirmation</ion-button>
      </div>
    </ion-content>
  </ion-page>
</template>

<script setup lang="ts">
import {
  IonContent,
  IonHeader,
  IonPage,
  IonTitle,
  IonToolbar,
  IonButton,
} from '@ionic/vue';
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute();
const reservation = ref({
  firstName: route.query.firstName,
  lastName: route.query.lastName,
  email: route.query.email,
  breakfast: route.query.breakfast === 'true',
  checkIn: route.query.checkIn,
  checkOut: route.query.checkOut,
  roomTitle: route.query.roomTitle,
  roomPrice: route.query.roomPrice,
  roomExtras: route.query.roomExtras,
  roomDescription: route.query.roomDescription,
  roomImage: route.query.roomImage,
  roomImageTwo: route.query.roomImageTwo,
});

const printPage = () => {
  window.print();
};

onMounted(() => {
  console.log('Reservation details:', reservation.value);
});
</script>

<style scoped>
.header-toolbar {
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
}

ion-title {
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
}

.sub-title {
  font-size: 1.2rem;
  color: gray;
}

.confirmation-content {
  padding: 16px;
}

.booking-details {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 8px;
  margin-bottom: 16px;
}

.detail-item {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.detail-item label {
  font-weight: bold;
}

.room-images {
  display: flex;
  justify-content: space-around;
  margin: 16px 0;
}

.room-image {
  max-width: 28%;
  height: auto;
  border: 1px solid #ccc;
  padding: 8px;
}

.hotel-info {
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
}

@media print {
  ion-button {
    display: none;
  }
}
</style>
