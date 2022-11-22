package spring.layer.template.adapter.in.web.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.layer.template.adapter.in.web.sample.request.SampleRequest;
import spring.layer.template.domain.port.in.web.sample.SampleUseCase;
import spring.layer.template.domain.port.in.web.sample.dto.SampleDto;

@RestController
@RequiredArgsConstructor
public class SampleController {

    private final SampleUseCase useCase;

    @PostMapping
    public ResponseEntity<SampleDto.Response> sample(@RequestBody SampleRequest request) {
        SampleDto.Request requestDto = new SampleDto.Request(null);
        return ResponseEntity.ok(useCase.sample(requestDto));
    }
}
