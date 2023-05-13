package spring.layer.client.sample.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.layer.client.sample.feign.model.SampleCallModel.Request;
import spring.layer.client.sample.feign.model.SampleCallModel.Response;

@FeignClient(name = "sample-client",url = "http://localhost:3000",configuration = SampleClientConfiguration.class)
public interface SampleFeignClient {

  @GetMapping(value = "/hello",produces = "application/json")
  Response call(@RequestParam Request req);

}
