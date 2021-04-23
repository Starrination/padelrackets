package com.starrination.padelrackets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PadelRacketsService {

    @Autowired
    private RacketRepository racketRepository;

    public Racket persistRacket(Racket racket) {
        if (validRacket(racket)) {
            return racketRepository.save(racket);
        } else {
            throw new InternalServerErrorException("Could not persist racket " + racket.toString());
        }
    }

    boolean validRacket(Racket racket) {
        return racket.getBrand() != null && racket.getModel() != null && racket.getVersion() != null;
    }
}
