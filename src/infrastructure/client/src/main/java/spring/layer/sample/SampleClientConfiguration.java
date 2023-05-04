package spring.layer.sample;

import feign.Logger;
import feign.Logger.Level;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("spring.layer")
public class SampleClientConfiguration {

  @Bean
  public ErrorDecoder errorDecoder() {
    return new SampleClientErrorDecoder();
  }

  @Bean
  public Logger.Level feignLoggerLevel(){
    return Level.BASIC;
  }
}
