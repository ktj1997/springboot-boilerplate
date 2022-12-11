package spring.layer.api.service.sample.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.layer.api.service.sample.flow.SampleFlow;
import spring.layer.api.service.sample.usecase.dto.SampleUseCaseDto;
import spring.layer.domain.model.Sample;

@Service
@RequiredArgsConstructor
public class SampleUseCase {

  private final SampleFlow sampleFlow;

  @Transactional
  public SampleUseCaseDto.Response sample(SampleUseCaseDto.Request request) {
    Sample sample = sampleFlow.findSample();
    return new SampleUseCaseDto.Response();
  }
}
