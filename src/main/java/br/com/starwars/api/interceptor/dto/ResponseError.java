package br.com.starwars.api.interceptor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {

    private List<ErrorDto> errors;

    public static ResponseError buildResponseError(List<ErrorDto> errorList) {
        return ResponseError.builder()
                .errors(errorList)
                .build();
    }

    public static List<ErrorDto> buildInternalServerError() {
        var code = "INTERNAL SERVER ERROR";
        var title = "INTERNAL SERVER ERROR";
        var detail = "Erro interno da API";
        return new ArrayList<>(Collections.singletonList(new ErrorDto(title, detail)));
    }
}

