package at.fhtw.boutiquehoteltechnikum2024bd.service;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomFilterDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.entity.Room;
import at.fhtw.boutiquehoteltechnikum2024bd.mapper.RoomMapper;
import at.fhtw.boutiquehoteltechnikum2024bd.repository.BookingRepository;
import at.fhtw.boutiquehoteltechnikum2024bd.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {


    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper, BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
        this.bookingRepository = bookingRepository;
    }

    public List<RoomDTO> getRooms() {
        return roomRepository.findAll()
                .stream()
                .map(roomMapper::roomToRoomDTO)
                .toList();
    }

    public RoomDTO getRoomById(Long id) {
        return roomRepository.findById(id)
                .map(roomMapper::roomToRoomDTO)
                .orElse(null);
    }

    public List<RoomDTO> getRoomsWithFilters(RoomFilterDTO filter) {
        LocalDate startDate = filter.getStartDate();
        LocalDate endDate = filter.getEndDate();
        Integer numberOfBeds = filter.getNumberOfBeds();
        Double maxPrice = filter.getMaxPrice();

        return roomRepository.findAll()
                .stream()
                .filter(room -> (numberOfBeds == null || room.getBedcount() == numberOfBeds) &&
                        (maxPrice == null || room.getPrice() <= maxPrice) &&
                        isRoomAvailable(room, startDate, endDate))
                .map(roomMapper::roomToRoomDTO)
                .collect(Collectors.toList());
    }

    private boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return true;
        }

        return bookingRepository.findBookingsForRoomAndDateRange(room.getId(), startDate, endDate).isEmpty();
    }

}
