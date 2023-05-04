package spring.layer.api.config.web.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

  private String message;
  private LocalDateTime timeStamp;
}
