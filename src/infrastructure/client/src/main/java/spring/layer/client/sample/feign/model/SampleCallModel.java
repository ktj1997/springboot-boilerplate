package spring.layer.client.sample.feign.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class SampleCallModel {

  @Getter
  @AllArgsConstructor
  public static class Request {
    private String data;
  }

  /** Feign의 Decoding은 Jackson의 정책에 따라 NoArgsConstructor + Setter 이다. */
  @Getter
  @Setter
  @NoArgsConstructor
  public static class Response {
    private String data;
  }
}
