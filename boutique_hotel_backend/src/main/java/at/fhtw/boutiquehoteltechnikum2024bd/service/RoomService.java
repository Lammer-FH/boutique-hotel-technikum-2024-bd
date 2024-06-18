package at.fhtw.boutiquehoteltechnikum2024bd.service;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.ResponseDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomFilterDTO;
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
        LocalDate startDate = filter.getStartDate();
        LocalDate endDate = filter.getEndDate();
        Integer numberOfBeds = filter.getNumberOfBeds();
        Double maxPrice = filter.getMaxPrice();
        Pageable pageable= PageRequest.of(pageSize, pageNumber);
        Page<Room> roomsPage= roomRepository.findAll(pageable);
        Collection<Room>roomsList= roomsPage.getContent();

        List<RoomDTO> content=roomsList
                .stream()
                .filter(room -> (numberOfBeds == null || room.getBedcount() == numberOfBeds) &&
                        (maxPrice == null || room.getPrice() <= maxPrice) &&
                        isRoomAvailable(room, startDate, endDate))
                .map(roomMapper::roomToRoomDTO)
                .collect(Collectors.toList());


        ResponseDTO responseDTO= new ResponseDTO();

        responseDTO.setContent(content);
        responseDTO.setPageNumber(roomsPage.getNumber());
        responseDTO.setPageSize(roomsPage.getSize());
        responseDTO.setTotalElementsCount(roomsPage.getTotalElements());
        responseDTO.setTotalPages(roomsPage.getTotalPages());

        responseDTO.setLast(roomsPage.isLast());


        return responseDTO;
    }

    private boolean isRoomAvailable(Room room, LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return true;
        }

        return bookingRepository.findBookingsForRoomAndDateRange(room.getId(), startDate, endDate).isEmpty();
    }

}
