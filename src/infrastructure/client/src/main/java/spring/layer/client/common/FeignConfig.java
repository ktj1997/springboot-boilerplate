package spring.layer.client.common;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("spring.layer")
@ImportAutoConfiguration(FeignAutoConfiguration.class)
public class FeignConfig {}
