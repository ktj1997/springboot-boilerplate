package spring.layer.converter;

import org.springframework.stereotype.Component;
import spring.layer.domain.sample.model.Sample;
import spring.layer.entity.SampleEntity;

@Component
public class SampleConverter {

  public Sample convertEntityToModel(SampleEntity entity) {
    return new Sample(entity.getName());
  }
}
