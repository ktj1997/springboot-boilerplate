package spring.layer.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.layer.api.service.SampleApplicationService;

@RestController
@RequiredArgsConstructor
public class SampleController {

  private final SampleApplicationService sampleApplicationService;

  @GetMapping
  public String ping(){
    return "pong";
  }

}
