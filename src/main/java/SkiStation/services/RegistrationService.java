package SkiStation.services;

import SkiStation.entities.Course;
import SkiStation.entities.Registration;
import SkiStation.entities.Skier;
import SkiStation.repositories.CourseRep;
import SkiStation.repositories.RegistrationRep;
import SkiStation.repositories.SkierRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService implements InterfaceRegistrationService {

    private final RegistrationRep registrationRep;
    private final SkierRep skierRep;
    private final CourseRep courseRep;

    @Override
    public Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur) {
        Skier skier = skierRep.findById(numSkieur)
                .orElseThrow(() -> new RuntimeException("Skier not found with id: " + numSkieur));

        registration.setSkier(skier);
        return registrationRep.save(registration);
    }

    @Override
    public Registration assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Registration registration = registrationRep.findById(numRegistration)
                .orElseThrow(() -> new RuntimeException("Registration not found with id: " + numRegistration));

        Course course = courseRep.findById(numCourse)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + numCourse));

        registration.setCourse(course);
        return registrationRep.save(registration);
    }
}

