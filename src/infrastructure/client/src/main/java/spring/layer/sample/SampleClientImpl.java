package spring.layer.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.layer.domain.sample.port.outbound.client.SampleClient;
import spring.layer.domain.sample.port.outbound.client.model.SampleCallClientModel;
import spring.layer.sample.converter.SampleConverter;
import spring.layer.sample.feign.SampleFeignClient;
import spring.layer.sample.feign.model.SampleCallModel;

@Component
@RequiredArgsConstructor
public class SampleClientImpl implements SampleClient {

  private final SampleFeignClient sampleFeignClient;
  private final SampleConverter sampleConverter;


  @Override
  public SampleCallClientModel.Response call(SampleCallClientModel.Request clientReq) {
    SampleCallModel.Request request = sampleConverter.toInfraRequest(clientReq);
    SampleCallModel.Response response = sampleFeignClient.call(request);

    return sampleConverter.toClientResponse(response);
  }
}
