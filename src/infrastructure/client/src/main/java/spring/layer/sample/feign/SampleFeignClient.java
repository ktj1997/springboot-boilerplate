package spring.layer.sample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.layer.sample.feign.model.SampleCallModel;

@FeignClient(name = "sample-client",url = "http://localhost:3000",configuration = SampleClientConfiguration.class)
public interface SampleFeignClient {

  @GetMapping(value = "/hello",produces = "application/json")
  SampleCallModel.Response call(@RequestParam SampleCallModel.Request req);

}
