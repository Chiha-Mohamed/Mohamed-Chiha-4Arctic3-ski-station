package SkiStation.services;


import SkiStation.entities.Skier;
import SkiStation.entities.Subscription;
import SkiStation.repositories.SkierRep;
import SkiStation.repositories.SubscriptionRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkierService implements InterfaceSkierService {

    private final SkierRep skierRepository;
    private final SubscriptionRep subscriptionRepository;

    @Override
    public List<Skier> retrieveAllSkiers() {
        return skierRepository.findAll();
    }

    @Override
    public Skier addSkier(Skier skier) {
        Subscription subscription = skier.getSubscription();
        subscriptionRepository.save(subscription);
        return skierRepository.save(skier);
    }

    @Override
    public void removeSkier(Long numSkier) {
        skierRepository.findById(numSkier).ifPresent(skier -> {
            subscriptionRepository.delete(skier.getSubscription());
            skierRepository.delete(skier);
        });
    }

    @Override
    public Skier retrieveSkier(Long numSkier) {
        return skierRepository.findById(numSkier).orElse(null);
    }
}