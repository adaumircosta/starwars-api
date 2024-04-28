package br.com.starwars.api.interceptor;

import br.com.starwars.api.exceptions.BaseException;
import br.com.starwars.api.exceptions.FeignCustomException;
import br.com.starwars.api.interceptor.dto.ErrorDto;
import br.com.starwars.api.interceptor.dto.ResponseError;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestControllerAdvice
public class ControllerAdviceHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseError> handleAllExceptions(Exception e, HttpServletRequest request) {
		log.error("Traduzindo Exception para ResponseEntity {}", e.toString());
		final var errors = ResponseError.buildInternalServerError();
		return new ResponseEntity<>(ResponseError.buildResponseError(errors), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ResponseError> handleBaseExceptions(BaseException e, HttpServletRequest request) {
		log.error("Traduzindo BaseException para ResponseEntity {}", e.toString());
		return new ResponseEntity<>(ResponseError.buildResponseError(e.getErros()), HttpStatusCode.valueOf(e.getHttpStatus()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		log.error("Traduzindo MethodArgumentNotValidException para ResponseEntity", e);
		final var erros = e.getBindingResult().getFieldErrors().stream().map(ErrorDto::ofFieldError).collect(toList());
		return new ResponseEntity<>(ResponseError.buildResponseError(erros), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FeignCustomException.class)
	public ResponseEntity<Object> handleFeignException(FeignCustomException e, HttpServletRequest request) {
		log.error("Traduzindo FeignCustomException para ResponseEntity {}", e.toString());
		return new ResponseEntity<>(ResponseError.buildResponseError(e.getErros()), HttpStatusCode.valueOf(e.getHttpStatus()));
	}


}
