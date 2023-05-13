package spring.layer.storage.sample.repository;

import java.util.Optional;
import spring.layer.storage.sample.entity.SampleEntity;

public interface SampleQueryDslRepository {

  Optional<SampleEntity> findWith();
}
