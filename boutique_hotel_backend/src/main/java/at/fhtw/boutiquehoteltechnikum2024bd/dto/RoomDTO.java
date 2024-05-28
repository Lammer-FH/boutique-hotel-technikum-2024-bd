package at.fhtw.boutiquehoteltechnikum2024bd.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDTO {
    private Long id;
    private String title;
    private String description;
    private int bedcount;
    private float price;
    private String extras;
    private String images;
}
