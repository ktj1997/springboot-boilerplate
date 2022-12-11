package spring.layer.infrastructure.persistence.rdb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.layer.domain.model.Sample;
import spring.layer.infrastructure.persistence.rdb.querydsl.SampleQueryDslRepository;

public interface SampleJpaRepository
    extends JpaRepository<Sample, Long>, SampleQueryDslRepository {}
