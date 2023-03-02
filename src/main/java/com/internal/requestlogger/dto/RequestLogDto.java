package com.internal.requestlogger.dto;

import lombok.Data;

@Data
public class RequestLogDto {

    private String method;

    private String url;

    private String contentType;

    private String content;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
