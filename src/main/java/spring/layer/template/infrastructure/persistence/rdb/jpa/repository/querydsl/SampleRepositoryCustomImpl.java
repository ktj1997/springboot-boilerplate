package spring.layer.template.infrastructure.persistence.rdb.jpa.repository.querydsl;

import static spring.layer.template.domain.model.QSample.sample;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.layer.template.domain.model.Sample;

@Component
@RequiredArgsConstructor
public class SampleRepositoryCustomImpl implements SampleRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Sample> findSampleByIdIsLowerThan(Long id) {
        return jpaQueryFactory.selectFrom(sample).where(sample.id.lt(id)).fetch();
    }
}
