package spring.layer.domain.sample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.layer.domain.sample.port.inbound.SampleUseCase;
import spring.layer.domain.sample.port.outbound.client.SampleClient;
import spring.layer.domain.sample.port.outbound.persistence.SampleQueryHandler;

@Service
@RequiredArgsConstructor
public class SampleDomainService implements SampleUseCase {

  private final SampleQueryHandler sampleQueryHandler;
  private final SampleClient sampleClient;

}
