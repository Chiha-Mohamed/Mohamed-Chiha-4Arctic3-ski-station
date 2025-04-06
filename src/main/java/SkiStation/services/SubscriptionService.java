package SkiStation.services;

import SkiStation.entities.Subscription;
import SkiStation.entities.TypeSubscription;
import SkiStation.repositories.SubscriptionRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SubscriptionService implements InterfaceSubscriptionService {

    private final SubscriptionRep subscriptionRepository;

    // Other methods...

    @Override
    public Set<Subscription> getSubscriptionByType(TypeSubscription type) {
        return Set.of();
    }

    @Override
    public List<Subscription> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return subscriptionRepository.findByStartDateBetween(startDate, endDate);
    }
}
