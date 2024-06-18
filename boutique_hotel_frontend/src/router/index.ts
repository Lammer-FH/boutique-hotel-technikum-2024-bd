import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import HomePage from '../views/HomePage.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    name: 'Home',
    component: HomePage
  },
  {
    path: '/rooms',
    name: 'Rooms',
    component: () => import('../views/RoomsPage.vue')
  },
  {
    path: '/room/:id',
    name: 'ViewRoom',
    component: () => import('../views/ViewRoomPage.vue')
  },
  {
    path: '/reservation/:id',
    name: 'Reservation',
    component: () => import('../views/ReservationPage.vue')
  },
  {
    path: '/preview-reservation',
    name: 'PreviewReservation',
    component: () => import('../views/PreviewReservationPage.vue')
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
