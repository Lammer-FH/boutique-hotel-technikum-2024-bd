package at.fhtw.boutiquehoteltechnikum2024bd.mapper;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.BookingDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    Booking bookingDTOToBooking(BookingDTO bookingDTO);

    BookingDTO bookingToBookingDTO(Booking booking);
}
