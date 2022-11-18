package spring.layer.template.application.usecase.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.layer.template.domain.processor.sample.SampleProcessor;

@Service
@RequiredArgsConstructor
public class SampleUseCase {

    private final SampleProcessor processor;
}
