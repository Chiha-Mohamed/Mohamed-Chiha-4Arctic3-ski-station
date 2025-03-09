package SkiStation.repositories;

import SkiStation.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PisteRep extends JpaRepository<Piste, Long> {
}
