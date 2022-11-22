package spring.layer.template.domain.processor.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.layer.template.domain.port.out.repository.sample.SampleRepository;

@Component
@RequiredArgsConstructor
public class SampleProcessor {

    private final SampleRepository sampleRepository;
}
