package at.fhtw.boutiquehoteltechnikum2024bd.controller;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@CrossOrigin(origins = "http://localhost:5173")

public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping
    public List<RoomDTO> getRooms() {
        return roomService.getRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id){
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

}
