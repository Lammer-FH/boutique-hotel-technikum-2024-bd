package at.fhtw.boutiquehoteltechnikum2024bd.dto;

import at.fhtw.boutiquehoteltechnikum2024bd.entity.Room;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * DTO for {@link at.fhtw.boutiquehoteltechnikum2024bd.entity.Booking}
 */
@Value
public class BookingDTO implements Serializable {
    Long id;
    @NotNull
    String first_name;
    @NotNull
    String last_name;
    @NotNull
    String email;
    Boolean breakfast;
    @NotNull
    Room room;
    @NotNull
    LocalDate checkIn;
    @NotNull
    LocalDate checkOut;
}