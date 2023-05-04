package spring.layer.sample.repository;

import java.util.Optional;
import spring.layer.sample.entity.SampleEntity;

public interface SampleQueryDslRepository {

  Optional<SampleEntity> findWith();
}
