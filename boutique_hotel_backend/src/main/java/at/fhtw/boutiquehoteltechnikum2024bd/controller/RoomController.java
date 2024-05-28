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
@RequestMapping("/api/rooms")
public class RoomController {


    @Autowired
    private RoomService roomService;


    @GetMapping("/")
    public ResponseEntity<List<RoomDTO>> getRooms(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) Integer numberOfBeds,
            @RequestParam(required = false) Double maxPrice) {

        RoomFilterDTO filter = new RoomFilterDTO();
        filter.setStartDate(startDate);
        filter.setEndDate(endDate);
        filter.setNumberOfBeds(numberOfBeds);
        filter.setMaxPrice(maxPrice);

        return ResponseEntity.ok(roomService.getRoomsWithFilters(filter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id){
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

}
