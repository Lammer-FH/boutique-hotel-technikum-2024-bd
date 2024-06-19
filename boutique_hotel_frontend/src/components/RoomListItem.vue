<template>
  <ion-item @click="navigateToRoom" class="list-item">
    <div slot="start"></div>
    <ion-label class="ion-text-wrap">
      <h2 class="room-title">
        {{ room.title }}
        <span class="price">
          <ion-note>${{ room.price }}</ion-note>
          <ion-icon aria-hidden="true" :icon="chevronForward" size="small" v-if="isIos()"></ion-icon>
        </span>
      </h2>
      <img
          :src="parsedImage"
          alt="Hotel Room Image"
          class="thumbnail"
      />
      <div class="text">
        <p>Beds: {{ room.bedcount }}</p>
        <div class="extras">
          <IonIcon :icon="iconMapper[extra]" v-for="extra in parsedExtras" :key="extra" class="extra-icon" />
        </div>
        <p>{{ room.description }}</p>
      </div>
    </ion-label>
  </ion-item>
</template>

<script setup lang="ts">
import { IonIcon, IonItem, IonLabel, IonNote } from '@ionic/vue';
import { chevronForward } from 'ionicons/icons';
import { useRoomStore } from '@/roomStore';
import { useRouter } from 'vue-router';
import {
  barbell,
  restaurant,
  wifi,
  wine,
  boat,
  gameController,
  bus,
  airplane,
  leafOutline,
} from "ionicons/icons";
import { computed } from "vue";

const iconMapper: any = {
  "Free WiFi": wifi,
  "Breakfast included": restaurant,
  "free Gym": barbell,
  "free drinks": wine,
  "free Boat Trips": boat,
  "Gaming Room": gameController,
  "Airport pickup": airplane,
  "free Shuttle Service": bus,
  "Spa access": leafOutline
};

const props = defineProps({
  room: Object,
  checkIn: String,
  checkOut: String,
});

const parsedExtras = computed(() => {
  return props.room?.extras.split(",").map((extra) => extra.trim()) || [];
});
const { images } = props.room!;
const parsedImage = JSON.parse(images)[0];

const isIos = () => {
  const win = window as any;
  return win && win.Ionic && win.Ionic.mode === "ios";
};

const roomStore = useRoomStore();
const router = useRouter();

const navigateToRoom = async () => {
  roomStore.loading = true;
  await router.push(`/room/${props.room.id}?checkIn=${props.checkIn}&checkOut=${props.checkOut}`);
};
</script>

<style scoped>
.list-item {
  --padding-start: 0;
  --inner-padding-end: 0;
}

.list-item ion-label {
  margin-top: 12px;
  margin-bottom: 12px;
}

.list-item h2 {
  font-weight: 600;
  margin: 0;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}

.list-item p {
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
  width: 95%;
}

.list-item .date {
  align-items: center;
  display: flex;
}

.list-item ion-icon {
  color: #c9c9ca;
}

.list-item ion-note {
  font-size: 0.9375rem;
  margin-right: 8px;
  font-weight: normal;
}

.list-item ion-note.md {
  margin-right: 14px;
}

.list-item .dot {
  display: block;
  height: 12px;
  width: 12px;
  border-radius: 50%;
  align-self: start;
  margin: 16px 10px 16px 16px;
}

.list-item .dot-unread {
  background: var(--ion-color-primary);
}

.thumbnail {
  margin-top: 5px;
  width: 140px;
  height: 70px;
  float: left;
}

.text {
  margin-top: 4px;
  padding-left: 150px;
}

.extras {
  display: flex!important;
  flex-direction: row;
}

.extra-icon {
  margin-right: 5px!important;
  margin-top: 4px;
  margin-bottom: 4px;
  color: #000dff !important;
}
</style>
