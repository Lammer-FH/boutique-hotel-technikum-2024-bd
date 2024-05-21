export interface Room {
  id: number;
  title: string;
  beds: number;
  price: number;
  extra: string;
  description: string;
}

const rooms: Room[] = [
  {
    id: 0,
    title: 'Deluxe Suite',
    beds: 2,
    price: 250,
    extra: 'Breakfast included',
    description: 'A spacious suite with a king-size bed, en-suite bathroom, and a beautiful view of the city.'
  },
  {
    id: 1,
    title: 'Standard Room',
    beds: 1,
    price: 100,
    extra: 'Free Wi-Fi',
    description: 'A comfortable room with a queen-size bed, suitable for solo travelers or couples.'
  },
  {
    id: 2,
    title: 'Family Room',
    beds: 3,
    price: 180,
    extra: 'Kids stay free',
    description: 'A large room with two queen-size beds and an additional bunk bed, perfect for families.'
  },
  {
    id: 3,
    title: 'Economy Room',
    beds: 1,
    price: 75,
    extra: 'Complimentary coffee',
    description: 'A cozy room with a single bed, ideal for budget travelers.'
  },
  {
    id: 4,
    title: 'Penthouse Suite',
    beds: 3,
    price: 500,
    extra: 'Private pool',
    description: 'An exclusive suite on the top floor with luxurious amenities and a private pool.'
  },
  {
    id: 5,
    title: 'Twin Room',
    beds: 2,
    price: 120,
    extra: 'Daily housekeeping',
    description: 'A room with two single beds, perfect for friends or colleagues traveling together.'
  },
  {
    id: 6,
    title: 'Executive Room',
    beds: 1,
    price: 220,
    extra: 'Access to executive lounge',
    description: 'A high-end room with a king-size bed, designed for business travelers with exclusive lounge access.'
  },
  {
    id: 7,
    title: 'Honeymoon Suite',
    beds: 1,
    price: 300,
    extra: 'Champagne on arrival',
    description: 'A romantic suite with a king-size bed, perfect for honeymooners, includes a private balcony and jacuzzi.'
  }
];

export const getRooms = () => rooms;

export const getRoom = (id: number) => rooms.find(m => m.id === id);