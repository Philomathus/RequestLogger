package com.internal.requestlogger.vo;

public class ResponseHelper {
    public static <T> ResponseVo<T> success() {
        return new ResponseVo<>(ParentCommonStatusCode.SUCCESS);
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<>(ParentCommonStatusCode.SUCCESS, data);
    }

    public static <T> ResponseVo<T> error() {
        return new ResponseVo<>(ParentCommonStatusCode.FAILURE);
    }

    public static <T> ResponseVo<T> invalid() {
        return new ResponseVo<>(ParentCommonStatusCode.INVALID);
    }
}
