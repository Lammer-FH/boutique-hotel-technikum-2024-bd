package at.fhtw.boutiquehoteltechnikum2024bd.service;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.mapper.RoomMapper;
import at.fhtw.boutiquehoteltechnikum2024bd.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {


    private static final Logger log = LoggerFactory.getLogger(RoomService.class);
    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public List<RoomDTO> getRooms() {
        return roomRepository.findAll()
                .stream()
                .map(roomMapper::roomToRoomDTO)
                .toList();
    }

}
