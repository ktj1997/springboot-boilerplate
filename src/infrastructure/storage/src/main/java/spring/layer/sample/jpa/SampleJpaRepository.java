package spring.layer.sample.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.layer.sample.entity.SampleEntity;
import spring.layer.sample.querydsl.SampleQueryDslRepository;

@Repository
public interface SampleJpaRepository
    extends JpaRepository<SampleEntity, Long>, SampleQueryDslRepository {}
