package spring.layer.storage.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.layer.storage.sample.entity.SampleEntity;

@Repository
public interface SampleJpaRepository
    extends JpaRepository<SampleEntity, Long>, SampleQueryDslRepository {}
