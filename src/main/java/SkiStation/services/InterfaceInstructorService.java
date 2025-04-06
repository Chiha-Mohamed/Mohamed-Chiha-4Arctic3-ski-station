package SkiStation.services;

import SkiStation.entities.Instructor;

import java.util.List;

public interface InterfaceInstructorService {
    List<Instructor> retrieveInstructors();
    Instructor addInstructor(Instructor instructor);
    Instructor updateInstructor(Instructor instructor);
    Instructor retrieveInstructor(Long numInstructor);
    Instructor addInstructorAndAssignToCourse(Instructor instructor, Long numCourse);
}