package spring.layer.sample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import spring.layer.sample.feign.model.SampleCallModel;

@FeignClient(name = "sample-client",url = "http://localhost:3000",configuration = SampleClientConfiguration.class)
public interface SampleFeignClient {

  @GetMapping
  SampleCallModel.Response call(SampleCallModel.Request req);

}
