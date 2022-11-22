package spring.layer.template.domain.port.in.web.sample;

import spring.layer.template.domain.port.in.web.sample.dto.SampleDto;

public interface SampleUseCase {

    SampleDto.Response sample(SampleDto.Request request);
}
