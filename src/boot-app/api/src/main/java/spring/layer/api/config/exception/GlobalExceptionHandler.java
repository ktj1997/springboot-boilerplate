package spring.layer.api.config.exception;

import java.time.LocalDateTime;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import spring.layer.api.config.web.response.ErrorResponse;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(RuntimeException.class)
  public ErrorResponse handleApiException(RuntimeException ex) {
    ex.printStackTrace();
    return new ErrorResponse(ex.getMessage(), LocalDateTime.now());
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ErrorResponse handleNotFound(HttpRequestMethodNotSupportedException ex) {
    GlobalExceptionMessage message = GlobalExceptionMessage.HANDLER_NOT_FOUND;
    return new ErrorResponse(message.getMessage(), LocalDateTime.now());
  }

  /**
   * @Valid Exception Handling
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    GlobalExceptionMessage type = GlobalExceptionMessage.REQUEST_BODY_VALIDATION_FAILURE;
    StringBuilder sb = new StringBuilder();

    sb.append(type.getMessage()).append("\n");

    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
      String field = fieldError.getField();
      String input =
          fieldError.getRejectedValue() == null ? "" : fieldError.getRejectedValue().toString();
      String exceptionMessage = fieldError.getDefaultMessage();

      sb.append(
          String.format(
              "field: %s || input: %s || message : %s \n", field, input, exceptionMessage));
    }

    return new ErrorResponse(sb.toString(), LocalDateTime.now());
  }

  @ExceptionHandler({MethodArgumentTypeMismatchException.class})
  public ErrorResponse handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
    GlobalExceptionMessage message = GlobalExceptionMessage.REQUEST_PARAMETER_BINDING_FAILURE;
    return new ErrorResponse(message.getMessage() + ex.getValue(), LocalDateTime.now());
  }
}
