// CourseController.java
package SkiStation.controller;


import SkiStation.entities.Course;
import SkiStation.services.InterfaceCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final InterfaceCourseService courseservice;

    @GetMapping("/getall")
    public List<Course> retrieveAllCourses() {
        return courseservice.retrieveAllCourses();
    }

    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseservice.addCourse(course);
    }

    @PutMapping("/update/{numCourse}")
    public Course updateCourse(@PathVariable Long numCourse, @RequestBody Course course) {
        course.setNumCourse(numCourse);
        return courseservice.updateCourse(course);
    }
    @GetMapping("/retrive/{numCourse}")
    public Course retrieveCourse(@PathVariable Long numCourse) {
        return courseservice.retrieveCourse(numCourse);
    }
}