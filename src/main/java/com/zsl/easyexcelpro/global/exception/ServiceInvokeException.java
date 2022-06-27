package com.zsl.easyexcelpro.global.exception;

public class ServiceInvokeException extends RuntimeException {
    private static final long serialVersionUID = 3713530339378310587L;

    public ServiceInvokeException() {
    }

    public ServiceInvokeException(String message) {
        super(message);
    }
}
