package spring.layer.client.sample.feign;

import feign.Logger;
import feign.Logger.Level;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleClientConfiguration {

  @Bean
  public ErrorDecoder sampleErrorDecoder() {
    return new SampleClientErrorDecoder();
  }

  @Bean
  public Logger.Level feignLoggerLevel() {
    return Level.BASIC;
  }
}
