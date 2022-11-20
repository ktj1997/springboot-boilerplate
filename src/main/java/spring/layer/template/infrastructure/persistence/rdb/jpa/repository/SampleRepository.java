package spring.layer.template.infrastructure.persistence.rdb.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.layer.template.domain.model.Sample;
import spring.layer.template.infrastructure.persistence.rdb.jpa.repository.querydsl.SampleRepositoryCustom;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long>, SampleRepositoryCustom {}
