package at.fhtw.boutiquehoteltechnikum2024bd.repository;

import at.fhtw.boutiquehoteltechnikum2024bd.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    @Override
    Collection<Room> findAll();

}
