package br.com.starwars.api.exceptions;

import org.springframework.http.HttpStatus;

public class FeignCustomException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public FeignCustomException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
