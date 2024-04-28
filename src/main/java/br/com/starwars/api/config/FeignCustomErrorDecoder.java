package br.com.starwars.api.config;

import br.com.starwars.api.exceptions.FeignCustomException;
import br.com.starwars.api.interceptor.dto.ErrorDto;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;

@RequiredArgsConstructor
@Slf4j
public class FeignCustomErrorDecoder implements ErrorDecoder {

    private static final String TEXT_PARSE_CLIENT_ERROR = "Error enquanto esta sendo lido a resposta do corpo do cliente";
    private static final String INTEGRATION_ERROR_MESSAGE = "A integração com a {0} retornou um erro.";

    @Override
    public Exception decode(final String client, Response response) {
        final HttpStatus httpStatus = HttpStatus.valueOf(response.status());
        final String apiName = getNameApi(response);
        final String message = MessageFormat.format(INTEGRATION_ERROR_MESSAGE, apiName);
        logErrorResponse(response, apiName);
        return new FeignCustomException(httpStatus.value(), buildErrorDto(message));
    }

    private void logErrorResponse(final Response response, String apiName) {

        final String responseBody;
        try {
            if (Objects.nonNull(response.body())) {
                responseBody = IOUtils.toString(response.body().asReader(UTF_8));
                log.error(
                        MessageFormat.format("Erro na chamada da API {0}, retornando o seguinte erro {1}", apiName, responseBody));
            }
            log.error(MessageFormat.format("Erro na chamada da API {0}, sem corpo na resposta", apiName));
        } catch (IOException e) {
            log.error(TEXT_PARSE_CLIENT_ERROR, e);
        }
    }

    private static String getNameApi(Response response){
        return response.request().requestTemplate().feignTarget().name();
    }

    private ErrorDto buildErrorDto(String message) {
        return ErrorDto
                .builder()
                .title("Feign Error")
                .detail(message)
                .build();
    }
}
