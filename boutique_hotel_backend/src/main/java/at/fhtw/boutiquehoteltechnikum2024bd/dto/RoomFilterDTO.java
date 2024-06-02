package at.fhtw.boutiquehoteltechnikum2024bd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.time.LocalDate;

@Getter
@Setter
public class RoomFilterDTO {
    private LocalDate startDate;

    private LocalDate endDate;

    private Integer numberOfBeds;

    private Double maxPrice;
}
