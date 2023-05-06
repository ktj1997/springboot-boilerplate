package spring.layer.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.layer.domain.sample.port.inbound.SampleUseCase;

@Service
@RequiredArgsConstructor
public class SampleApplicationService {
  private final SampleUseCase sampleUseCase;

  public String sample() {
    return sampleUseCase.sample();
  }
}
