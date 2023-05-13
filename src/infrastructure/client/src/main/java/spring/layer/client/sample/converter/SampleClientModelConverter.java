package spring.layer.client.sample.converter;

import org.springframework.stereotype.Component;
import spring.layer.client.sample.feign.model.SampleCallModel.Request;
import spring.layer.client.sample.feign.model.SampleCallModel.Response;
import spring.layer.domain.sample.port.outbound.client.model.SampleCallClientModel;

@Component
public class SampleClientModelConverter {

  /**
   * DomainModelRequest -> InfraModelRequest
   */
  public Request toInfraRequest(SampleCallClientModel.Request clientRequest){
    return new Request("hello");
  }

  /**
   * InfraModelResponse -> DomainModelResponse
   */
  public SampleCallClientModel.Response toClientResponse(Response infraResponse){
    return new SampleCallClientModel.Response(infraResponse.getData());
  }
}
