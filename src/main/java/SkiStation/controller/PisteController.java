// PisteController.java
package SkiStation.controller;


import SkiStation.entities.Piste;
import SkiStation.services.InterfacePisteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pistes")
@RequiredArgsConstructor
public class PisteController {

    private final InterfacePisteService pisteService;

    @GetMapping("/getall")
    public List<Piste> retrieveAllPistes() {
        return pisteService.retrieveAllPistes();
    }

    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping("/update/{numPiste}")
    public Piste updatePiste(@PathVariable Long numPiste, @RequestBody Piste piste) {
        piste.setNumPiste(numPiste);
        return pisteService.updatePiste(piste);
    }

    @GetMapping("/get/{numPiste}")
    public Piste retrievePiste(@PathVariable Long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }
}