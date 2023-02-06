package com.sample.ddt.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Data
public class ResultBean<T> {
    private int code = 0;
    private String message = "SUCCESS";
    private T data;

    private ResultBean() {
    }

    public static <T> ResultBean<T> success(Boolean data) {
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.code = ResultCode.SUCCESS.getCode();
        resultBean.message = ResultCode.SUCCESS.getMessage();
        resultBean.data = (T) data;
        return resultBean;
    }

    public static <T> ResultBean<T> success(Optional<T> data) {
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.code = ResultCode.SUCCESS.getCode();
        resultBean.message = ResultCode.SUCCESS.getMessage();
        resultBean.data = (T) data;
        return resultBean;
    }

    public static <T> ResultBean<T> error(int code, String message) {
        ResultBean<T> resultBean = new ResultBean<>();
        resultBean.code = code;
        resultBean.message = message;
        return resultBean;
    }
}
