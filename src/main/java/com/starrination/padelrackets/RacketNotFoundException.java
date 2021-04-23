package com.starrination.padelrackets;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "resource not found")
public class RacketNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    RacketNotFoundException(Integer id) {
        super("Could not find racket " + id);
    }
}
