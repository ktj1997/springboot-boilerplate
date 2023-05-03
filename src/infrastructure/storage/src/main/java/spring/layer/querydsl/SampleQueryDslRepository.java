package spring.layer.querydsl;

import java.util.Optional;
import spring.layer.entity.SampleEntity;

public interface SampleQueryDslRepository {

  Optional<SampleEntity> findWith();
}
