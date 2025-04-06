package SkiStation.services;

import SkiStation.entities.Skier;
import SkiStation.entities.TypeSubscription;

import java.util.List;

public interface InterfaceSkierService {
    List<Skier> retrieveAllSkiers();
    Skier addSkier(Skier skier);
    void removeSkier(Long numSkier);
    Skier retrieveSkier(Long numSkier);
    Skier assignSkierToPiste(Long numSkier, Long numPiste);
    Skier addSkierAndAssignToCourse(Skier skier, Long numCourse);
    List<Skier> retrieveSkiersBySubscriptionType(TypeSubscription typeAbonnement);

}