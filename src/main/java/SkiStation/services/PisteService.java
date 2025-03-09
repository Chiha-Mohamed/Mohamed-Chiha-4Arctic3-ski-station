package SkiStation.services;


import SkiStation.entities.Piste;
import SkiStation.repositories.PisteRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PisteService implements InterfacePisteService {

    private final PisteRep pisteRepository;


    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        Piste existingPiste = pisteRepository.findById(piste.getNumPiste()).orElse(null);
        if (existingPiste != null) {
            existingPiste.setNamePiste(piste.getNamePiste());
            existingPiste.setColor(piste.getColor());
            existingPiste.setLength(piste.getLength());
            existingPiste.setSlope(piste.getSlope());
            return pisteRepository.save(existingPiste);
        }
        return null;
    }


    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElse(null);
    }
}