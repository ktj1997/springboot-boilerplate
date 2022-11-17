package spring.layer.template.config.exception;

import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private String code;
    private String message;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(GlobalExceptionType type) {
        this.code = type.getCode();
        this.message = type.getMessage();
    }
}
