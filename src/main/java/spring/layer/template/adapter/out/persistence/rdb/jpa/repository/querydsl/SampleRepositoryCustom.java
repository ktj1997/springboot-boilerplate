package spring.layer.template.adapter.out.persistence.rdb.jpa.repository.querydsl;

import java.util.List;
import spring.layer.template.adapter.out.persistence.rdb.jpa.entity.SampleJpaEntity;

public interface SampleRepositoryCustom {
    List<SampleJpaEntity> findSampleByIdIsLowerThan(Long id);
}
