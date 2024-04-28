package br.com.starwars.api.exceptions;

import br.com.starwars.api.interceptor.dto.ErrorDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class BaseException extends RuntimeException {


    private final Integer httpStatus;

    private final List<ErrorDto> erros;

    private BaseException(Integer httpStatus, ErrorDto errorDto) {
        this.erros = List.of(errorDto);
        this.httpStatus = httpStatus;
    }

    public BaseException(Integer httpStatus,
                         String title,
                         String detail) {
        this(httpStatus, new ErrorDto(title, detail));
    }
}
