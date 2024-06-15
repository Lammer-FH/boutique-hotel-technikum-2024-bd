package at.fhtw.boutiquehoteltechnikum2024bd.service;

import at.fhtw.boutiquehoteltechnikum2024bd.dto.BookingDTO;
import at.fhtw.boutiquehoteltechnikum2024bd.entity.Booking;
import at.fhtw.boutiquehoteltechnikum2024bd.mapper.BookingMapper;
import at.fhtw.boutiquehoteltechnikum2024bd.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Autowired
    public BookingService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.bookingDTOToBooking(bookingDTO);
        Booking savedBooking = bookingRepository.save(booking);
        return bookingMapper.bookingToBookingDTO(savedBooking);
    }
}
