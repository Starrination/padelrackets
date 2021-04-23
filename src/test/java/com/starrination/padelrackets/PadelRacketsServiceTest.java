package com.starrination.padelrackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PadelRacketsServiceTest {

    @Test
    void validRacket() {
        PadelRacketsService padelRacketsService = new PadelRacketsService();
        assertFalse(padelRacketsService.validRacket(new Racket("Bullpadel", null, null)));
        assertFalse(padelRacketsService.validRacket(new Racket("Bullpadel", "Vertex", null)));
        assertTrue(padelRacketsService.validRacket(new Racket("Bullpadel", "Vertex", "2021")));
    }
}