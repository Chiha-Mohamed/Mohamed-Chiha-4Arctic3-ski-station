package SkiStation.controller;


import SkiStation.entities.Instructor;
import SkiStation.services.InterfaceInstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InterfaceInstructorService instructorService;

    @GetMapping
    public List<Instructor> retrieveInstructors() {
        return instructorService.retrieveInstructors();
    }

    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }

    @PutMapping("/update/{numInstructor}")
    public Instructor updateInstructor(@RequestBody Instructor instructor,@PathVariable Long numInstructor) {
        instructor.setNumInstructor(numInstructor);
        return instructorService.updateInstructor(instructor);
    }

    @GetMapping("/retrive/{numInstructor}")
    public Instructor retrieveInstructor(@PathVariable Long numInstructor) {
        return instructorService.retrieveInstructor(numInstructor);
    }
}