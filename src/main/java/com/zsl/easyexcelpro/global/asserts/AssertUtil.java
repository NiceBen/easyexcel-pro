package com.zsl.easyexcelpro.global.asserts;

import com.zsl.easyexcelpro.contant.enums.ApiCodeEnum;
import com.zsl.easyexcelpro.global.exception.BusinessException;
import com.zsl.easyexcelpro.global.exception.ServiceInvokeException;

public class AssertUtil {

    public AssertUtil() {
    }

    /**
     * 服务调用异常
     * @param expression
     * @param message
     */
    public static void isTrueServiceInvoke(boolean expression, String message) {
        if (!expression) {
            throw new ServiceInvokeException(message);
        }
    }

    /**
     * 抛出异常（默认错误1000）
     * @param message
     */
    public static void businessInvalid(String message) {
        throw new BusinessException(ApiCodeEnum.SERVICE_ERROR.getValue(), message);    }

    /**
     * 表达式为真，即抛出异常（默认错误1000）
     * @param expression
     * @param message
     */
    public static void businessInvalid(boolean expression, String message) {
        if (expression) {
            throw new BusinessException(ApiCodeEnum.SERVICE_ERROR.getValue(), message);
        }
    }

    /**
     * 表达式为真，即抛出异常
     * @param expression
     * @param message
     */
    public static void businessInvalid(boolean expression, int code, String message) {
        if (expression) {
            throw new BusinessException(code, message);
        }
    }
}
