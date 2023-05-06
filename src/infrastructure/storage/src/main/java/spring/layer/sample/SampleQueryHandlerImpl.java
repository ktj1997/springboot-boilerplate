package spring.layer.sample;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.layer.domain.sample.model.Sample;
import spring.layer.domain.sample.port.outbound.persistence.SampleQueryHandler;
import spring.layer.sample.converter.SamplePersistenceModelConverter;
import spring.layer.sample.repository.SampleJpaRepository;

@Component
@RequiredArgsConstructor
public class SampleQueryHandlerImpl implements SampleQueryHandler {

  private final SampleJpaRepository sampleJpaRepository;
  private final SamplePersistenceModelConverter converter;

  @Override
  public List<Sample> findAll() {
    return sampleJpaRepository.findAll().stream()
        .map(converter::convertEntityToModel)
        .collect(Collectors.toList());
  }
}
