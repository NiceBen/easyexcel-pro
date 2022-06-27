package com.zsl.easyexcelpro.global.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class WebException extends RuntimeException {
    private static final long serialVersionUID = -1443457720642842072L;

    private boolean isSuccess;
    private int responseCode;
    private String responseMsg;

    public WebException(String message) {
        super(message);
    }
}
