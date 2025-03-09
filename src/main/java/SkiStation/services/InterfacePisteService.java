package SkiStation.services;

import SkiStation.entities.Piste;

import java.util.List;

public interface InterfacePisteService {
    List<Piste> retrieveAllPistes();
    Piste addPiste(Piste piste);
    Piste updatePiste(Piste piste);
    Piste retrievePiste(Long numPiste);
}