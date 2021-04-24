package com.starrination.padelrackets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

@RestController
public class PadelRacketsController {

    @Autowired
    private RacketRepository racketRepository;

    @Autowired
    private PadelRacketsService padelRacketsService;

    @GetMapping(path="/rackets")
    @CrossOrigin()
    public List<Racket> getRackets() {
        List<Racket> rackets = new ArrayList<>();
        for(Racket racket: racketRepository.findAll()) {
            rackets.add(racket);
        }
        return rackets;
    }

    @GetMapping(path="/rackets/{id}")
    @CrossOrigin()
    public Racket getRacket(@PathVariable Integer id) {
        return racketRepository.findById(id).orElseThrow(() -> new RacketNotFoundException(id));
    }

    @PostMapping(path="/rackets")
    @CrossOrigin()
    public ResponseEntity<Racket> addRacket(@RequestBody Racket racket) {
        padelRacketsService.persistRacket(racket);
        return new ResponseEntity<>(racket, HttpStatus.CREATED);
    }

    @PostMapping (path="/rackets/{id}")
    @CrossOrigin()
    public Racket updateRacket(@RequestBody Racket newRacket, @PathVariable Integer id) {
        return racketRepository.findById(id)
        .map(racket -> {
            racket.setBrand(newRacket.getBrand());
            racket.setModel(newRacket.getModel());
            racket.setVersion(newRacket.getVersion());
            return racketRepository.save(racket);
         })
         .orElseThrow(() -> new RacketNotFoundException(id));
    } 

    @DeleteMapping (path="/rackets/{id}")
    @CrossOrigin()
    public void deleteRacket(@PathVariable Integer id) {
        racketRepository.deleteById(id);
    } 

}
