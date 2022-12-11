package spring.layer.infrastructure.persistence.rdb.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.layer.domain.model.QSample;
import spring.layer.domain.model.Sample;

@Repository
@RequiredArgsConstructor
public class SampleJpaRepositoryImpl implements SampleRepositoryCustom {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public Optional<Sample> findWith() {
    Sample sample =
        jpaQueryFactory.selectFrom(QSample.sample).where(QSample.sample.id.eq(1L)).fetchOne();
    return Optional.of(sample);
  }
}
