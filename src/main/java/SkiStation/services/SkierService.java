package SkiStation.services;

import SkiStation.entities.*;
import SkiStation.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkierService implements InterfaceSkierService {

    private final SkierRep skierRepository;
    private final SubscriptionRep subscriptionRepository;
    private final PisteRep pisteRep;
    private final RegistrationRep registrationRepository;
    private final CourseRep courseRep;

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

    @Override
    public Skier assignSkierToPiste(Long numSkier, Long numPiste) {
        Skier skier = skierRepository.findById(numSkier)
                .orElseThrow(() -> new RuntimeException("Skier not found with id: " + numSkier));

        Piste piste = pisteRep.findById(numPiste)
                .orElseThrow(() -> new RuntimeException("Piste not found with id: " + numPiste));

        if (skier.getPistes() == null) {
            skier.setPistes(new ArrayList<>());
        }

        skier.getPistes().add(piste);

        return skierRepository.save(skier);
    }

    @Override
    public Skier addSkierAndAssignToCourse(Skier skier, Long numCourse) {
        Course course = courseRep.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + numCourse));

        if (skier.getSubscription() == null) {
            skier.setSubscription(new Subscription());
        }
        subscriptionRepository.save(skier.getSubscription());

        Registration registration = new Registration();
        registration.setCourse(course);
        registration.setSkier(skier);
        registrationRepository.save(registration);

        skier.getRegistrations().add(registration);

        return skierRepository.save(skier);
    }

    @Override
    public List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeAbonnement) {
        List<Skier> allSkiers = skierRepository.findAll();
        return allSkiers.stream()
                .filter(skier -> skier.getSubscription() != null
                        && skier.getSubscription().getTypeSub().equals(typeAbonnement))
                .collect(Collectors.toList());
    }


}
