package spring.layer.sample.converter;

import org.springframework.stereotype.Component;
import spring.layer.domain.sample.port.outbound.client.model.SampleCallClientModel;
import spring.layer.sample.feign.model.SampleCallModel;

@Component
public class SampleClientModelConverter {

  /**
   * DomainModelRequest -> InfraModelRequest
   */
  public SampleCallModel.Request toInfraRequest(SampleCallClientModel.Request clientRequest){
    return new SampleCallModel.Request("hello");
  }

  /**
   * InfraModelResponse -> DomainModelResponse
   */
  public SampleCallClientModel.Response toClientResponse(SampleCallModel.Response infraResponse){
    return new SampleCallClientModel.Response(infraResponse.getData());
  }
}
