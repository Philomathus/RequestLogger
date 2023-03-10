package com.internal.requestlogger.exception;

import com.internal.requestlogger.vo.ServiceStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ServiceStatusCode> handleServiceException(ServiceException ex) {
        return new ResponseEntity<>(new ServiceStatusCode(ex.getCode(), ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
