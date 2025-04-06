package SkiStation.services;

import SkiStation.entities.Registration;

public interface InterfaceRegistrationService {
    Registration addRegistrationAndAssignToSkier(Registration registration, Long numSkieur);
    Registration assignRegistrationToCourse(Long numRegistration, Long numCourse);

}
