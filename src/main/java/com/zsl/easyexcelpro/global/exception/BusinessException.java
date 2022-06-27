package com.zsl.easyexcelpro.global.exception;

import com.zsl.easyexcelpro.global.result.Level;
import lombok.Getter;

/**
 * 业务异常，异常信息会返回到前端展示给用户
 */
@Getter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -3452362111305082948L;
    private int code;
    private Level level;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Level level, String message) {
        super(message);
        this.level = level;
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
