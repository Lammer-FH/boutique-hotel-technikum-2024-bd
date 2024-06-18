package at.fhtw.boutiquehoteltechnikum2024bd.dto;

import lombok.Data;

import java.util.List;
@Data
public class ResponseDTO {
    private List<RoomDTO> content;
    private int pageSize;
    private int pageNumber;
    private long totalElementsCount;
    private int totalPages;
    private boolean last;

}
