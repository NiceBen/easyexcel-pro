package com.zsl.easyexcelpro.global.result;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = -6532198579731999472L;
    private int responseCode;
    private String responseMsg;
    private boolean isSuccess;
    private T data;

    public static ApiResult<String> success() {
        return success("success");
    }

    public static <T> ApiResult<T> success(T data) {
        return success(0, "操作成功", data);
    }

    public static <T> ApiResult<T> success(int code, String message, T data) {
        return ApiResult.<T>builder()
                .responseCode(code)
                .responseMsg(message)
                .isSuccess(true)
                .data(data)
                .build();
    }

    public static ApiResult<String> fail() {
        return fail(-1);
    }

    public static ApiResult<String> fail(int code) {
        return fail(code, "fail");
    }

    public static <T> ApiResult<T> fail(T data) {
        return fail(-1, data);
    }

    public static <T> ApiResult<T> fail(int code, T data) {
        return fail(code, "操作失败", data);

    }

    public static <T> ApiResult<T> fail(int code, String message, T data) {
        return ApiResult.<T>builder()
                .responseCode(code)
                .responseMsg(message)
                .isSuccess(false)
                .data(data)
                .build();
    }
}
