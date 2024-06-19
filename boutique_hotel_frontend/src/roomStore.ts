import { defineStore } from 'pinia';
import axios from 'axios';
import { Room, allRoomsMetaData } from './types';

const apiUrl = 'http://localhost:8001';

export const useRoomStore = defineStore('room', {
  state: () => ({
    singleRoom: null as Room | null,
    allRooms: [] as Room[],
    allRoomsMetaDeta: null as allRoomsMetaData | null,
    currentPage: 1,
    startDate: null as string | null,
    endDate: null as string | null,
    loading: false,
  }),

  actions: {
    setCurrentPage(page: number) {
      this.currentPage = page;
    },

    async fetchRoomData(roomId: string) {
      this.loading = true;
      try {
        const response = await axios.get(`${apiUrl}/rooms/${roomId}`);
        const roomData = response.data;
        roomData.images = JSON.parse(roomData.images);
        this.singleRoom = roomData;
      } catch (error) {
        console.error('Error fetching data:', error);
      } finally {
        this.loading = false;
      }
    },

    async fetchAllRooms() {
      this.loading = true;
      try {
        const response = await axios.get(`${apiUrl}/rooms?pageSize=5&pageNumber=${this.currentPage - 1}`);
        this.allRooms = response.data.content;
        this.allRoomsMetaDeta = {
          totalElementsCount: response.data.totalElementsCount,
          totalPages: response.data.totalPages,
        };
      } catch (error) {
        console.error('Error fetching data:', error);
      } finally {
        this.loading = false;
      }
    },

    async checkAvailability(startDate: string, endDate: string) {
      this.loading = true;
      try {
        this.startDate = startDate;
        this.endDate = endDate;
        const response = await axios.get(`${apiUrl}/rooms?startDate=${startDate}&endDate=${endDate}&pageSize=5&pageNumber=${this.currentPage - 1}`);
        this.allRooms = response.data.content;
        this.allRoomsMetaDeta = {
          totalElementsCount: response.data.totalElementsCount,
          totalPages: response.data.totalPages,
        };
      } catch (error) {
        console.error('Error checking availability:', error);
      } finally {
        this.loading = false;
      }
    },

    async updateData(page: number) {
      this.setCurrentPage(page);
      if (this.startDate && this.endDate) {
        await this.checkAvailability(this.startDate, this.endDate);
      } else {
        await this.fetchAllRooms();
      }
    },
  },
});
