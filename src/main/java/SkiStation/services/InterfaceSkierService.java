package SkiStation.services;

import SkiStation.entities.Skier;

import java.util.List;

public interface InterfaceSkierService {
    List<Skier> retrieveAllSkiers();
    Skier addSkier(Skier skier);
    void removeSkier(Long numSkier);
    Skier retrieveSkier(Long numSkier);
}