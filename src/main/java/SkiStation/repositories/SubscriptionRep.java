package SkiStation.repositories;

import SkiStation.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRep extends JpaRepository<Subscription, Long> {
}
