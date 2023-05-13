package spring.layer.storage.sample.converter;

import org.springframework.stereotype.Component;
import spring.layer.domain.sample.model.Sample;
import spring.layer.storage.sample.entity.SampleEntity;

@Component
public class SamplePersistenceModelConverter {

  public Sample convertEntityToModel(SampleEntity entity) {
    return new Sample(entity.getName());
  }
}
