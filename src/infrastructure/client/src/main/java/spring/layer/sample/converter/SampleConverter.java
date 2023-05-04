package spring.layer.sample.converter;

import org.springframework.stereotype.Component;
import spring.layer.domain.sample.port.outbound.client.model.SampleCallClientModel;
import spring.layer.sample.feign.model.SampleCallModel;

@Component
public class SampleConverter {

  /**
   * DomainModel -> InfraModel
   */
  public SampleCallModel.Request toInfraRequest(SampleCallClientModel.Request clientRequest){
    return new SampleCallModel.Request();
  }

  public SampleCallModel.Response toInfraResponse(SampleCallClientModel.Request clientResponse){
    return new SampleCallModel.Response();
  }


  /**
   * InfraModel -> DomainModel
   */
  public SampleCallClientModel.Request toClientRequest(SampleCallModel.Request infraRequest){
    return new SampleCallClientModel.Request();
  }

  public SampleCallClientModel.Response toClientResponse(SampleCallModel.Response infraResponse){
    return new SampleCallClientModel.Response();
  }
}
