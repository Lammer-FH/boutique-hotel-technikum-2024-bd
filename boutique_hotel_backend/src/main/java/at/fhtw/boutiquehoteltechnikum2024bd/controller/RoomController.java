package at.fhtw.boutiquehoteltechnikum2024bd.controller;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.ResponseDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomFilterDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.service.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("rooms")
public class RoomController {


    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping()
    public ResponseEntity<ResponseDTO> getRooms(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber) {

        RoomFilterDTO filter = new RoomFilterDTO();
        filter.setStartDate(startDate);
        filter.setEndDate(endDate);

        return new ResponseEntity<>(roomService.getRoomsWithFilters(filter, pageNumber, pageSize), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id){
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

}
