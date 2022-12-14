package spring.layer.api.service.sample.flow;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.layer.api.port.persistence.sample.query.SampleQueryHandler;
import spring.layer.domain.sample.entity.Sample;

@Component
@RequiredArgsConstructor
public class SampleFlow {

  private final SampleQueryHandler sampleQueryHandler;

  public Sample findSample(Long id) {
    return sampleQueryHandler
        .findSampleById(id)
        .orElseThrow(
            () -> {
              throw new RuntimeException("Sample Entity Not Found");
            });
  }
}
