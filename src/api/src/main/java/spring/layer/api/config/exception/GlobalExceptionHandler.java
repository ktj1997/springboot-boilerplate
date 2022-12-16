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
import spring.layer.domain.common.exception.ApiException;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ApiException.class)
  public ErrorResponse handleApiException(ApiException ex) {
    return new ErrorResponse(ex.getCode(), ex.getMessage(), LocalDateTime.now());
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ErrorResponse handleNotFound(HttpRequestMethodNotSupportedException ex) {
    GlobalExceptionType type = GlobalExceptionType.HANDLER_NOT_FOUND;
    return new ErrorResponse(type.getCode(), type.getMessage(), LocalDateTime.now());
  }

  /**
   * @Valid Exception Handling
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    GlobalExceptionType type = GlobalExceptionType.REQUEST_BODY_VALIDATION_FAILURE;
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

    return new ErrorResponse(type.getCode(), sb.toString(), LocalDateTime.now());
  }

  @ExceptionHandler({MethodArgumentTypeMismatchException.class})
  public ErrorResponse handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
    GlobalExceptionType type = GlobalExceptionType.REQUEST_PARAMETER_BINDING_FAILURE;
    return new ErrorResponse(
        type.getCode(), type.getMessage() + ex.getValue(), LocalDateTime.now());
  }
}
