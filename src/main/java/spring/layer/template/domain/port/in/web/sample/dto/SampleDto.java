package spring.layer.template.domain.port.in.web.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import spring.layer.template.domain.dto.sample.SimpleSampleDto;

public class SampleDto {

    @Getter
    @AllArgsConstructor
    public static class Request {

        private SimpleSampleDto simple;
    }

    @Getter
    @AllArgsConstructor
    public static class Response {

        private SimpleSampleDto simple;
    }
}
