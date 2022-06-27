package com.zsl.easyexcelpro.global.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }
}
