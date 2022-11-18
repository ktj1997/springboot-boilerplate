package spring.layer.template.presentation.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import spring.layer.template.application.usecase.sample.SampleUseCase;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SampleUseCase useCase;
}
