package spring.layer.infrastructure.persistence.rdb.querydsl;

import java.util.Optional;
import spring.layer.domain.model.Sample;

public interface SampleRepositoryCustom {

  Optional<Sample> findWith();
}
