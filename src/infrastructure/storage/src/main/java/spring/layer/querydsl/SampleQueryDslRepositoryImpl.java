package spring.layer.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.layer.entity.QSample;
import spring.layer.entity.SampleEntity;

@Repository
@RequiredArgsConstructor
public class SampleQueryDslRepositoryImpl implements SampleQueryDslRepository {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public Optional<SampleEntity> findWith() {
    SampleEntity sampleEntity =
        jpaQueryFactory.selectFrom(QSample.sample).where(QSample.sample.id.eq(1L)).fetchOne();
    return Optional.of(sampleEntity);
  }
}
