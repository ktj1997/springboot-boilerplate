package spring.layer.domain.common.exception;

import lombok.Getter;

@Getter
public abstract class ApiException extends RuntimeException {
  private final String code;
  private final String message;

  public ApiException(BaseExceptionType exceptionType) {
    super(exceptionType.getMessage());
    this.code = exceptionType.getCode();
    this.message = exceptionType.getMessage();
  }
}
