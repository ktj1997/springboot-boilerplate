package spring.layer.domain.sample.service.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SampleExceptionMessage {
  SAMPLE_NOT_FOUND("Sample Not Found");

  private final String message;
}
