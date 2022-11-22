package spring.layer.template.adapter.out.persistence.rdb.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.layer.template.adapter.out.persistence.rdb.jpa.entity.SampleJpaEntity;
import spring.layer.template.adapter.out.persistence.rdb.jpa.repository.querydsl.SampleRepositoryCustom;

@Repository
public interface SampleRepository
        extends JpaRepository<SampleJpaEntity, Long>, SampleRepositoryCustom {}
