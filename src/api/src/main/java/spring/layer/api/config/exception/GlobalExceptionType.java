package spring.layer.api.config.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import spring.layer.domain.common.exception.BaseExceptionType;

@Getter
@RequiredArgsConstructor
public enum GlobalExceptionType implements BaseExceptionType {
  INTERNAL_SERVER_ERROR("SYSTEM-001", "Internal Server Error Occurred"),
  REQUEST_BODY_VALIDATION_FAILURE("SYSTEM-002", "RequestBody Validation Fail"),
  REQUEST_PARAMETER_BINDING_FAILURE("SYSTEM-003", "RequestParameter Validation Fail"),

  HANDLER_NOT_FOUND("SYSTEM-004", "Handler Not Found");

  private final String code;
  private final String message;
}
