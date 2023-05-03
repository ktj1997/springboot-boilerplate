package spring.layer.domain.sample.port.outbound.persistence;

import java.util.List;
import spring.layer.domain.sample.model.Sample;

public interface SampleQueryHandler {

  List<Sample> findAll();
}
