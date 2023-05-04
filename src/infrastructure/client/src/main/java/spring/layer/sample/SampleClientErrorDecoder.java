package spring.layer.sample;

import feign.Response;
import feign.codec.ErrorDecoder;
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
