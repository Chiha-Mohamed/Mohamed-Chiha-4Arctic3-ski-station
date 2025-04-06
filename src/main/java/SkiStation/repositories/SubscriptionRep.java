package SkiStation.repositories;

import SkiStation.entities.Subscription;
import SkiStation.entities.TypeSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SubscriptionRep extends JpaRepository<Subscription, Long> {
    List<Subscription> findByTypeSub(TypeSubscription typeSub);
    List<Subscription> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
