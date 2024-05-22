package at.fhtw.boutiquehoteltechnikum2024bd.mapper;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.RoomDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDTO roomToRoomDTO(Room room);

    Room roomDTOToRoom(RoomDTO roomDTO);
}
