<template>
  <ion-item v-if="room" :routerLink="'/room/' + room.id" :detail="false" class="list-item">
    <div slot="start" :class="!room.read ? 'dot dot-unread' : 'dot'"></div>
    <ion-label class="ion-text-wrap">
      <h2>
        {{ room.title }}
        <span class="price">
          <ion-note>${{ room.price }}</ion-note>
          <ion-icon aria-hidden="true" :icon="chevronForward" size="small" v-if="isIos()"></ion-icon>
        </span>
      </h2>
      <h3>Beds: {{ room.beds }}</h3>
      <p>{{ room.extra }}</p>
      <p>{{ room.description }}</p>
    </ion-label>
  </ion-item>
</template>


<script setup lang="ts">
import { IonIcon, IonItem, IonLabel, IonNote } from '@ionic/vue';
import { chevronForward } from 'ionicons/icons';

defineProps({
  room: Object,
});

const isIos = () => {
  const win = window as any;
  return win && win.Ionic && win.Ionic.mode === 'ios';
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
</style>