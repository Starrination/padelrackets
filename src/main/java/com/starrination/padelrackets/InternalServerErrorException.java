package com.starrination.padelrackets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "internal server error")
public class InternalServerErrorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    InternalServerErrorException(String message) {
        super(message);
    }
}
