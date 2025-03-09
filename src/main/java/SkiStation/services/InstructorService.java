package SkiStation.services;


import SkiStation.entities.Instructor;
import SkiStation.repositories.InstructorRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements InterfaceInstructorService {
    private final InstructorRep instructorRepository;

    @Override
    public List<Instructor> retrieveInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
        Instructor existingInstructor = instructorRepository.findById(instructor.getNumInstructor()).orElse(null);
        if (existingInstructor != null) {
            existingInstructor.setFirstName(instructor.getFirstName());
            existingInstructor.setLastName(instructor.getLastName());
            existingInstructor.setDateOfHire(instructor.getDateOfHire());
            return instructorRepository.save(existingInstructor);
        }
        return null;
    }
    @Override
    public Instructor retrieveInstructor(Long numInstructor) {
        return instructorRepository.findById(numInstructor).orElse(null);
    }
}
