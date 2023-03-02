package com.internal.requestlogger.vo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ResponseVo<T> {
    private int code;
    private String message;
    private T data;

    public ResponseVo(int code, String message) {
        this(code, message, (T) new ArrayList<>());
    }

    public ResponseVo(int code, String message, T data) {
        setCode(code);
        setMessage(message);
        setData(data);
    }

    public ResponseVo(ServiceStatusCode serviceStatusCode) {
        this(serviceStatusCode, (T) new ArrayList());
    }

    public ResponseVo(ServiceStatusCode serviceStatusCode, T data) {
        this(serviceStatusCode.getCode(), serviceStatusCode.getMessage(), data);
    }
}
