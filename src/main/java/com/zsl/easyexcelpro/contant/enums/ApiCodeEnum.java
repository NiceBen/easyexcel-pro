package com.zsl.easyexcelpro.contant.enums;

import lombok.Getter;

@Getter
public enum ApiCodeEnum {
    SERVICE_ERROR(3001, "服务调用异常"),
    PARAM_INVALID(3002, "参数不合法"),
    PARAM_FORMAT_INCORR(3003, "参数格式转换错误");

    private int value;
    private String message;

    ApiCodeEnum(int value) {
        this.value = value;
    }

    ApiCodeEnum(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public static ApiCodeEnum getObjectByValue(int code) {
        for (ApiCodeEnum apiCodeEnum : ApiCodeEnum.values()) {
            if (apiCodeEnum.getValue() == code) {
                return apiCodeEnum;
            }
        }
        return null;
    }
}
