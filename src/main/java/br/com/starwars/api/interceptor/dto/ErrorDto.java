package br.com.starwars.api.interceptor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {

	private String title;
	private String detail;

	public static ErrorDto ofFieldError(FieldError fieldError) {
		final var code = fieldError.getDefaultMessage();
		final var title = fieldError.getField();
		return new ErrorDto(code, title);
	}
}
