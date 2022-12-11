package spring.layer.api.controller.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.layer.api.controller.sample.request.SampleRequest;
import spring.layer.api.service.sample.usecase.SampleUseCase;
import spring.layer.api.service.sample.usecase.dto.SampleUseCaseDto;

@RestController
@RequiredArgsConstructor
public class SampleController {

  private final SampleUseCase sampleUseCase;

  @PostMapping
  public ResponseEntity<SampleUseCaseDto.Response> sample(@RequestBody SampleRequest request) {
    SampleUseCaseDto.Request requestDto = new SampleUseCaseDto.Request();
    return ResponseEntity.ok(sampleUseCase.sample(requestDto));
  }
}
