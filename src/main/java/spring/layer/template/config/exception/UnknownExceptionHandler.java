package spring.layer.template.config.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.layer.template.config.web.response.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class UnknownExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResponse handleApiException(Throwable ex) {

        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        log.error("Internal Server Error Occurred {}", sw.toString());

        GlobalExceptionType type = GlobalExceptionType.INTERNAL_SERVER_ERROR;
        return new ErrorResponse(type.getCode(), type.getMessage(), LocalDateTime.now());
    }
}
