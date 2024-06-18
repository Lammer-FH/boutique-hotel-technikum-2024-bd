import { defineStore } from 'pinia';
import axios from 'axios';
import { Room , allRoomsMetaData} from './types';  

const apiUrl = 'http://localhost:8001';

export const useRoomStore = defineStore('room', {
  state: () => ({
    singleRoom: null as Room | null,
    allRooms: [] as Room[],
    allRoomsMetaDeta: null as allRoomsMetaData| null
  }),
 
  actions: {
    async fetchRoomData(roomId:string) {
      try {
        const response = await axios.get(`${apiUrl}/rooms/${roomId}`);
        const roomData = response.data;
        roomData.images = JSON.parse(roomData.images); 
        this.singleRoom = roomData;
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    },
    async fetchAllRooms() {
      try {
        const response = await axios.get(`${apiUrl}/rooms`);
        this.allRooms = response.data.content;
        this.allRoomsMetaDeta={totalElementsCount: response.data.totalElementsCount,
            totalPages: response.data.totalPages
          };
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    },
    async checkAvailability(startDate:string, endDate:string) {
        try {
          const response = await axios.get(`${apiUrl}/rooms?startDate=${startDate}&endDate=${endDate}`);
          this.allRooms = response.data;
        } catch (error) {
          console.error('Error checking availability:', error);
        }
      
    },
   
  },
});
