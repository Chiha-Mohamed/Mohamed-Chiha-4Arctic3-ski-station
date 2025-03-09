package SkiStation.services;


import SkiStation.entities.Course;
import SkiStation.repositories.CourseRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements InterfaceCourseService {

    private final CourseRep courseRepository;

    @Override
    public List<Course> retrieveAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        Course existingCourse = courseRepository.findById(course.getNumCourse()).orElse(null);
        if (existingCourse != null) {
            existingCourse.setLevel(course.getLevel());
            existingCourse.setTypeCourse(course.getTypeCourse());
            existingCourse.setSupport(course.getSupport());
            existingCourse.setPrice(course.getPrice());
            existingCourse.setTimeSlot(course.getTimeSlot());
            existingCourse.setInstructor(course.getInstructor());
            return courseRepository.save(existingCourse);
        }
        return null;
    }
    @Override
    public Course retrieveCourse(Long numCourse) {
        return courseRepository.findById(numCourse).orElse(null);
    }
}