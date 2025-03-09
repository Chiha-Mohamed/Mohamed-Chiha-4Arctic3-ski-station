package SkiStation.repositories;

import SkiStation.entities.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRep extends JpaRepository<Registration, Long> {
}
