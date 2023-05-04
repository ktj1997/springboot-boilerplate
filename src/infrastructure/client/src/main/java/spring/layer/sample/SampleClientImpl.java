package spring.layer.sample;

import org.springframework.cloud.openfeign.FeignClient;
import spring.layer.domain.sample.port.outbound.client.SampleClient;

@FeignClient(name = "sample-client",configuration = SampleClientConfiguration.class)
public interface SampleClientImpl extends SampleClient {

}
