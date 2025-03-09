package SkiStation.repositories;

import SkiStation.entities.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRep extends JpaRepository<Instructor, Long> {
}
