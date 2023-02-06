package com.sample.ddt.config;

import com.sample.ddt.model.ResultBean;
import com.sample.ddt.model.ResultCode;
import org.hibernate.result.spi.ResultContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAOP<T> {
    private final static HttpStatus _500 = HttpStatus.INTERNAL_SERVER_ERROR;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResultBean<T>> Exception(Exception e) {
        // TODO: Print exception log
        return new ResponseEntity<>(ResultBean.error(ResultCode.Exception.getCode(), e.getMessage()), _500);
    }
}
