package spring.layer.sample.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.layer.sample.entity.QSampleEntity;
import spring.layer.sample.entity.SampleEntity;

@Repository
@RequiredArgsConstructor
public class SampleQueryDslRepositoryImpl implements SampleQueryDslRepository {

  private final JPAQueryFactory jpaQueryFactory;

  @Override
  public Optional<SampleEntity> findWith() {
    SampleEntity sampleEntity =
        jpaQueryFactory
            .selectFrom(QSampleEntity.sampleEntity)
            .where(QSampleEntity.sampleEntity.id.eq(1L))
            .fetchOne();
    return Optional.of(sampleEntity);
  }
}
