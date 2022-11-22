package spring.layer.template.adapter.out.persistence.rdb.jpa.repository.querydsl;

import static spring.layer.template.adapter.out.persistence.rdb.jpa.entity.QSampleJpaEntity.sampleJpaEntity;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.layer.template.adapter.out.persistence.rdb.jpa.entity.SampleJpaEntity;

@Component
@RequiredArgsConstructor
public class SampleRepositoryCustomImpl implements SampleRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<SampleJpaEntity> findSampleByIdIsLowerThan(Long id) {
        return jpaQueryFactory.selectFrom(sampleJpaEntity).where(sampleJpaEntity.id.lt(id)).fetch();
    }
}
