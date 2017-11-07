package com.oneler.domain.base;

import org.springframework.http.HttpStatus;

public class ResultBean<T> {
    private static final long serialVersionUID = 1L;

    private static final int HTTPCODE = HttpStatus.OK.value();

    private static final String SUCCESS = HttpStatus.Series.SUCCESSFUL.name();

    private int code = HTTPCODE;

    private String msg = SUCCESS;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public ResultBean() {
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultBean<T> success(T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }


    public ResultBean<T> failure(T data) {
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.msg = HttpStatus.Series.SERVER_ERROR.name();
        this.data = data;
        return this;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

}