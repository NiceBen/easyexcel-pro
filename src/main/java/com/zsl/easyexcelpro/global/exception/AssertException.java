package com.zsl.easyexcelpro.global.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class AssertException extends RuntimeException {
    private static final long serialVersionUID = -534489765593049553L;

    private int code;

    public AssertException(String message) {
        super(message);
    }

    public AssertException(int code) {
        this.code = code;
    }

    public AssertException(String message, int code) {
        super(message);
        this.code = code;
    }
}
