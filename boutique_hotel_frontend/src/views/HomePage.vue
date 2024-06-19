<template>
  <ion-page>
    <ion-content>
    <ion-header :translucent="true">
      <ion-toolbar color="primary">
        <ion-buttons slot="start">
          <ion-menu-button></ion-menu-button>
        </ion-buttons>
        <ion-title>Boutique Hotel Technikum</ion-title>
      </ion-toolbar>
    </ion-header>

      <swiper :speed="500" :loop=true :autoplay="{delay: 20}"  :slidesPerView="1"  :grabCursor="true" :pagination="true" navigation>
        <swiper-slide>
          <div class="carousel-image">
            <img src="https://www.hotel-outside.at/fileadmin/_processed_/c/8/csm_hotelansicht-winter_706409aa0e.jpg" alt="Hotel Image" />
          </div>
        </swiper-slide>
        <swiper-slide>
        <div class="carousel-image">
        <img src="https://www.greenpearls.com/wp-content/uploads/2018/02/fruehstueck-auf-der-terrasse-des-naturhotel-outside.jpg" alt="Hotel Image" />
        </div>
        </swiper-slide>
      </swiper>

      <div class="hotel-info">
        <h2>Welcome to Boutique Technikum</h2>
        <p>
          Nestled in the heart of the city, Boutique Technikum offers a serene escape from the hustle and bustle. Our hotel combines modern luxury with classic charm, providing an unforgettable stay for our guests. Enjoy world-class amenities, exceptional service, and a tranquil ambiance that will make you feel right at home.
        </p>
        <h3>Our History</h3>
        <p>
          Established in 1920, Boutique Technikum has been a cornerstone of hospitality in the city for over a century. Our hotel has a rich history of hosting notable guests and providing top-tier services. With its historic architecture and modern renovations, Boutique Technikum offers a unique blend of old-world charm and contemporary comfort.
        </p>
        <br>
        <div class="amenities">
          <IonIcon :icon="barbell" />
          <IonIcon :icon="restaurant" />
          <IonIcon :icon="wifi" />
          <IonIcon :icon="wine" />
        </div>
      </div>

      <ion-button  expand="block" class="check-availability-button" color="primary" :routerLink="'/rooms/'">View Rooms</ion-button>

      <ion-grid>
        <ion-row>
          <ion-col size="6">
            <div class="room-image">
              <img src="https://dynamic-media-cdn.tripadvisor.com/media/photo-o/22/37/bc/0f/hotel-outside.jpg?w=1200&h=-1&s=1" alt="Room Image">
            </div>
          </ion-col>
          <ion-col size="6">
            <div class="room-image">
              <img src ="https://www.hotel.de/de/media/image/6a/80/94/Naturhotel_Outside-Matrei_in_Osttirol-Doppelzimmer_Komfort-72897.jpg" alt="Room Image">
            </div>
          </ion-col>
        </ion-row>
      </ion-grid>

      <div class="contact-info">
        <h3>Contact:</h3>
        <p>Group BD</p>
        <p>technikum-wien@gmail.com</p>
        <h3>Address:</h3>
        <p>Höchstädtpl. 6,<br> 1200 Wien</p>
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
  IonButtons,
  IonMenuButton,
  IonIcon,
  IonGrid,
  IonRow,
  IonCol,
  IonButton
} from '@ionic/vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/css';
import '@ionic/vue/css/ionic-swiper.css';
import {barbell, restaurant, wifi, wine} from "ionicons/icons";
</script>

<style scoped>
.carousel-image img {
  width: 100%;
  height: 100%;
  object-fit: cover; /* Ensure the image covers the container while maintaining its aspect ratio */
}

.carousel-image {
  width: 100%;
  height: 400px;
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
}

.hotel-info {
  padding: 16px;
  text-align: center;
}

.amenities {
  display: flex;
  justify-content: space-around;
  margin: 16px 0;
}

.amenities ion-icon {
  font-size: 32px;
}

.room-image {
  height: 400px;
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
}

.check-availability-button{
  width: 100%;
  max-width: 500px;
  margin: 10px auto;

}
.contact-info {
  padding: 16px;
  text-align: center;
}
img {
  width: 100%;
  height: auto;
}
</style>
