package spring.layer.domain.sample.port.outbound.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SampleCallClientModel {

  @Getter
  @AllArgsConstructor
  public static class Request {}

  @Getter
  @AllArgsConstructor
  public static class Response {
    private String data;
  }
}
