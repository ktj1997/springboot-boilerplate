package spring.layer.domain.sample.port.outbound.client;

import spring.layer.domain.sample.port.outbound.client.model.SampleCallClientModel;

public interface SampleClient {

  SampleCallClientModel.Response call(SampleCallClientModel.Request request);

}
