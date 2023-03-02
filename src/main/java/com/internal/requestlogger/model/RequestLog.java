package com.internal.requestlogger.model;

import lombok.Data;

@Data
public class RequestLog {

    private Long id;

    private String method;

    private String url;

    private String contentType;

    private String content;

}
