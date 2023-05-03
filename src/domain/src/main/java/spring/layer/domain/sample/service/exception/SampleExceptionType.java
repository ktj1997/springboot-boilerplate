package spring.layer.domain.sample.service.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import spring.layer.domain.common.exception.BaseExceptionType;

@Getter
@RequiredArgsConstructor
public enum SampleExceptionType implements BaseExceptionType {
  SAMPLE_NOT_FOUND("SAMPLE_001", "Sample Not Found");

  private final String code;
  private final String message;
}
