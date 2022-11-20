package spring.layer.template.infrastructure.persistence.rdb.jpa.repository.querydsl;

import java.util.List;
import spring.layer.template.domain.model.Sample;

public interface SampleRepositoryCustom {
    List<Sample> findSampleByIdIsLowerThan(Long id);
}
