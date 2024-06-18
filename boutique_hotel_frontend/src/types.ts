export interface Room {
    id: string;
    title: string;
    price: number;
    images: string[];
    bedcount: number;
    extras: string;
    description: string;
  }
  
  export interface allRoomsMetaData{
    totalPages: number;
    totalElementsCount:number;
  }