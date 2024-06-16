package at.fhtw.boutiquehoteltechnikum2024bd.repository;

import at.fhtw.boutiquehoteltechnikum2024bd.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Page<Room> findAll(Pageable pageable);

}
