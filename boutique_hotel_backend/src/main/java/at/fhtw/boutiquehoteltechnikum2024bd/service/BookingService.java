package at.fhtw.boutiquehoteltechnikum2024bd.service;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.BookingDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.entity.Booking;
import at.fhtw.boutiquehoteltechnikum2024bd.entity.Room;
import at.fhtw.boutiquehoteltechnikum2024bd.mapper.BookingMapper;
import at.fhtw.boutiquehoteltechnikum2024bd.repository.BookingRepository;
import at.fhtw.boutiquehoteltechnikum2024bd.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.bookingMapper = bookingMapper;
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.bookingDTOToBooking(bookingDTO);

        // Check if room is available for the given dates
        List<Booking> conflictingBookings = bookingRepository.findBookingsForRoomAndDateRange(
                booking.getRoom().getId(), booking.getCheckIn(), booking.getCheckOut());

        if (!conflictingBookings.isEmpty()) {
            throw new RuntimeException("Room is not available for the selected dates");
        }

        Booking savedBooking = bookingRepository.save(booking);
        return bookingMapper.bookingToBookingDTO(savedBooking);
    }
}
