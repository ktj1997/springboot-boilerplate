package spring.layer.api.service.sample.flow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.layer.api.port.persistence.sample.SampleRepository;
import spring.layer.domain.model.Sample;

@Component
@RequiredArgsConstructor
public class SampleFlow {

  private final SampleRepository sampleRepository;

  public Sample findSample(Long id) {
    return sampleRepository
        .findSampleById(id)
        .orElseThrow(
            () -> {
              throw new RuntimeException("Sample Entity Not Found");
            });
  }
}
