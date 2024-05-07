package br.com.starwars.api.exceptions;

import org.springframework.http.HttpStatus;

public class DataNotFoundException extends BaseException{

    public DataNotFoundException(String title, String detail) {
        super(HttpStatus.NOT_FOUND.value(), title, detail);
    }
}
