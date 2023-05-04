package spring.layer.api.config.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.layer.api.config.web.response.ErrorResponse;

@Slf4j
@Order(value = Ordered.HIGHEST_PRECEDENCE + 1)
@RestControllerAdvice
public class UnknownExceptionHandler {

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Throwable.class)
  public ErrorResponse handleApiException(Throwable ex) {

    StringWriter sw = new StringWriter();
    ex.printStackTrace(new PrintWriter(sw));
    log.error("Internal Server Error Occurred {}", sw.toString());

    GlobalExceptionMessage message = GlobalExceptionMessage.INTERNAL_SERVER_ERROR;
    return new ErrorResponse(message.getMessage(), LocalDateTime.now());
  }
}
