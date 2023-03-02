package com.internal.requestlogger.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internal.requestlogger.vo.ResponseVo;
import com.internal.requestlogger.vo.ServiceStatusCode;
import lombok.Data;
import lombok.SneakyThrows;

@Data
public class ServiceException extends RuntimeException {
    private int code;
    private String message;
    private Object data;

    public ServiceException(ServiceStatusCode httpStatus) {
        this.code = httpStatus.getCode();
        this.message = httpStatus.getMessage();
    }

    public <T> ServiceException(ServiceStatusCode httpStatus, T data) {
        this.code = httpStatus.getCode();
        this.message = httpStatus.getMessage();
        this.data = data;
    }

    public ServiceException(int status, String message) {
        this.code = status;
        this.message = message;
    }

    public <T> ServiceException(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseVo<Object> toResponseVo() {
        return new ResponseVo(this.code, this.message, this.data);
    }

    @SneakyThrows
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(toResponseVo());
    }
}
