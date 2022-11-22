package spring.layer.template.adapter.out.persistence.rdb.impl.sample;

import org.springframework.stereotype.Component;
import spring.layer.template.domain.model.Sample;
import spring.layer.template.domain.port.out.repository.sample.SampleRepository;

@Component
public class SampleRepositoryImpl implements SampleRepository {

    @Override
    public Sample save(Sample entity) {
        return null;
    }

    @Override
    public Sample delete(Sample entity) {
        return null;
    }

    @Override
    public Sample update(Sample entity) {
        return null;
    }
}
