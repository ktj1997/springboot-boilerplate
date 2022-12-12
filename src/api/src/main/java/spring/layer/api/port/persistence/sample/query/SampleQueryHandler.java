package spring.layer.api.port.persistence.sample.query;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.layer.domain.model.Sample;
import spring.layer.infrastructure.persistence.rdb.jpa.SampleJpaRepository;

@Repository
@RequiredArgsConstructor
public class SampleQueryHandler {

  private final SampleJpaRepository sampleJpaRepository;

  public Optional<Sample> findSampleById(Long id) {
    return sampleJpaRepository.findById(id);
  }
}
