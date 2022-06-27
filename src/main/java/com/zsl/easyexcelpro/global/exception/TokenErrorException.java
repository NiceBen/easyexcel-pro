package com.zsl.easyexcelpro.global.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class TokenErrorException extends RuntimeException {
    private static final long serialVersionUID = 4918498976235809999L;

    public TokenErrorException(String message) {
        super(message);
    }
}
