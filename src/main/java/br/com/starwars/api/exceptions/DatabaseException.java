package br.com.starwars.api.exceptions;

import org.springframework.http.HttpStatus;

public class DatabaseException extends BaseException{

    public DatabaseException(String title, String detail) {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), title, detail);
    }
}
