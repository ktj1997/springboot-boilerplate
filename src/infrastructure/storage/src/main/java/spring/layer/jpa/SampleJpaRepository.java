package spring.layer.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.layer.entity.SampleEntity;
import spring.layer.querydsl.SampleQueryDslRepository;

public interface SampleJpaRepository
    extends JpaRepository<SampleEntity, Long>, SampleQueryDslRepository {}
