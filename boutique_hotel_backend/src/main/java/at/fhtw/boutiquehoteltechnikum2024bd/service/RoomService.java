package at.fhtw.boutiquehoteltechnikum2024bd.service;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.ResponseDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomFilterDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.entity.Booking;
import at.fhtw.boutiquehoteltechnikum2024bd.entity.Room;
import at.fhtw.boutiquehoteltechnikum2024bd.mapper.RoomMapper;
import at.fhtw.boutiquehoteltechnikum2024bd.repository.BookingRepository;
import at.fhtw.boutiquehoteltechnikum2024bd.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private static final Logger log = LoggerFactory.getLogger(RoomService.class);
    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;
    private final BookingRepository bookingRepository;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper, BookingRepository bookingRepository) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
        this.bookingRepository = bookingRepository;
    }

    public RoomDTO getRoomById(Long id) {
        return roomRepository.findById(id)
                .map(roomMapper::roomToRoomDTO)
                .orElse(null);
    }

    public ResponseDTO getRoomsWithFilters(RoomFilterDTO filter, int pageNumber, int pageSize) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize); // PageRequest expects 0-based page index

        Page<Room> roomsPage = roomRepository.findAll(pageable);

        List<RoomDTO> availableRooms = roomsPage.getContent()
                .stream()
                .filter(room -> (filter.getNumberOfBeds() == null || room.getBedcount() == filter.getNumberOfBeds()) &&
                        (filter.getMaxPrice() == null || room.getPrice() <= filter.getMaxPrice()) &&
                        isRoomAvailable(room, filter.getStartDate(), filter.getEndDate()))
                .map(roomMapper::roomToRoomDTO)
                .collect(Collectors.toList());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setContent(availableRooms);
        responseDTO.setPageNumber(pageNumber);
        responseDTO.setPageSize(pageSize);
        responseDTO.setTotalElementsCount(roomsPage.getTotalElements());
        responseDTO.setTotalPages(roomsPage.getTotalPages());

        return responseDTO;
    }

    private boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return true;
        }

        List<Booking> conflictingBookings = bookingRepository.findBookingsForRoomAndDateRange(room.getId(), startDate, endDate);
        return conflictingBookings.isEmpty();
    }
}
