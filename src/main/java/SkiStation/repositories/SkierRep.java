package SkiStation.repositories;

import SkiStation.entities.Skier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkierRep extends JpaRepository<Skier, Long> {
}
