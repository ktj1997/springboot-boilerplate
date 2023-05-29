package spring.layer.client.sample.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleClientErrorDecoder implements ErrorDecoder {
  @Override
  public Exception decode(String methodKey, Response response) {
    switch (response.status()) {
      case 400:
        throw new RuntimeException();
      case 404:
        throw new RuntimeException();
      default:
        throw new RuntimeException();
    }
  }
}
