package at.fhtw.boutiquehoteltechnikum2024bd.controller;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomFilterDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("rooms")
public class RoomController {


    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping()
    public ResponseEntity<List<RoomDTO>> getRooms(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
          ) {

        RoomFilterDTO filter = new RoomFilterDTO();
        filter.setStartDate(startDate);
        filter.setEndDate(endDate);

        return ResponseEntity.ok(roomService.getRoomsWithFilters(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id){
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

}
