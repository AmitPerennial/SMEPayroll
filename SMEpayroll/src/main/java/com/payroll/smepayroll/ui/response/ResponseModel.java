package com.payroll.smepayroll.ui.response;

public class ResponseModel<T> {

    private final Integer status;
    private final String message;
    private T response;

    public ResponseModel(Integer status, String message, T response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    public ResponseModel(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getResponse() {
        return response;
    }
}
