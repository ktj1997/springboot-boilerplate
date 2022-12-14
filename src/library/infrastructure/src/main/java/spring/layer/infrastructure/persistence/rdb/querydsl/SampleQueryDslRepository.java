package spring.layer.infrastructure.persistence.rdb.querydsl;

import java.util.Optional;
import spring.layer.domain.sample.entity.Sample;

public interface SampleQueryDslRepository {

  Optional<Sample> findWith();
}
