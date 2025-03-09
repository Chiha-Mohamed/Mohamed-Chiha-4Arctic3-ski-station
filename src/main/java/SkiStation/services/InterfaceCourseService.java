package SkiStation.services;

import SkiStation.entities.Course;

import java.util.List;

public interface InterfaceCourseService {
    List<Course> retrieveAllCourses();
    Course addCourse(Course course);
    Course updateCourse(Course course);
    Course retrieveCourse(Long numCourse);
}