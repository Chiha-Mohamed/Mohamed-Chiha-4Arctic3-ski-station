package SkiStation.controller;


import SkiStation.entities.Skier;
import SkiStation.services.SkierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skiers")
public class SkierController {

    private final SkierService skierService;

    @Autowired
    public SkierController(SkierService skierService) {
        this.skierService = skierService;
    }

    @PostMapping("/add")
    public Skier addSkier(@RequestBody Skier skier) {
        return skierService.addSkier(skier);
    }

    @GetMapping("/getall")
    public List<Skier> retrieveAllSkiers() {
        return skierService.retrieveAllSkiers();
    }

    @DeleteMapping("/delete/{numSkier}")
    public void removeSkier(@PathVariable Long numSkier) {
        skierService.removeSkier(numSkier);
    }

    @GetMapping("/retrieve/{numSkier}")
    public Skier retrieveSkier(@PathVariable Long numSkier) {
        return skierService.retrieveSkier(numSkier);
    }
}