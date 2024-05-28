package at.fhtw.boutiquehoteltechnikum2024bd.repository;

import at.fhtw.boutiquehoteltechnikum2024bd.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId AND " +
            "((b.checkIn <= :endDate AND b.checkOut >= :startDate) OR " +
            "(b.checkIn >= :startDate AND b.checkIn <= :endDate))")
    List<Booking> findBookingsForRoomAndDateRange(Long roomId, LocalDate startDate, LocalDate endDate);
}