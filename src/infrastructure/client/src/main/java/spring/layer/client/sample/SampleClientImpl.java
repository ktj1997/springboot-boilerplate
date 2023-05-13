package spring.layer.client.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.layer.client.sample.feign.model.SampleCallModel.Request;
import spring.layer.client.sample.feign.model.SampleCallModel.Response;
import spring.layer.domain.sample.port.outbound.client.SampleClient;
import spring.layer.domain.sample.port.outbound.client.model.SampleCallClientModel;
import spring.layer.client.sample.converter.SampleClientModelConverter;
import spring.layer.client.sample.feign.SampleFeignClient;

@Component
@RequiredArgsConstructor
public class SampleClientImpl implements SampleClient {

  private final SampleFeignClient sampleFeignClient;
  private final SampleClientModelConverter sampleClientModelConverter;


  @Override
  public SampleCallClientModel.Response call(SampleCallClientModel.Request clientReq) {
    Request request = sampleClientModelConverter.toInfraRequest(clientReq);
    Response response = sampleFeignClient.call(request);

    return sampleClientModelConverter.toClientResponse(response);
  }
}
