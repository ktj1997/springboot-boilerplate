package spring.layer.template.domain.service.sample;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.layer.template.domain.port.in.web.sample.SampleUseCase;
import spring.layer.template.domain.port.in.web.sample.dto.SampleDto;

@Service
public class SampleService implements SampleUseCase {

    @Override
    @Transactional
    public SampleDto.Response sample(SampleDto.Request request) {
        return null;
    }
}
