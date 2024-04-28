package br.com.starwars.api.exceptions;

import br.com.starwars.api.interceptor.dto.ErrorDto;
import lombok.Getter;

import java.util.List;

@Getter
public class FeignCustomException extends RuntimeException {

    private final Integer httpStatus;
    private final List<ErrorDto> erros;

    public FeignCustomException(Integer httpStatus, ErrorDto errorDto) {
        this.erros = List.of(errorDto);
        this.httpStatus = httpStatus;
    }
}
