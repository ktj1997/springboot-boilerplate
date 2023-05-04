package spring.layer.api.config.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GlobalExceptionMessage {
  INTERNAL_SERVER_ERROR("Internal Server Error Occurred"),
  REQUEST_BODY_VALIDATION_FAILURE("RequestBody Validation Fail"),
  REQUEST_PARAMETER_BINDING_FAILURE("RequestParameter Validation Fail"),

  HANDLER_NOT_FOUND("Handler Not Found");

  private final String message;
}
