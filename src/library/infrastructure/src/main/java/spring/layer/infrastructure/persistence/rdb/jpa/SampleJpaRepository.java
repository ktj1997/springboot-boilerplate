package spring.layer.infrastructure.persistence.rdb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.layer.domain.model.Sample;

public interface SampleJpaRepository extends JpaRepository<Sample, Long> {}
