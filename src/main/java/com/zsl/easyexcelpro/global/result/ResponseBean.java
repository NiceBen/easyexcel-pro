package com.zsl.easyexcelpro.global.result;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean<T> implements Serializable {
    private static final long serialVersionUID = -1074445228845624861L;
    private boolean isSuccess;
    private int responseCode;
    private String responseMsg;
    private T data;


    public ResponseBean(boolean isSuccess, int responseCode, String responseMsg, T data) {
        this.isSuccess = isSuccess;
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
        this.data = data;
    }

    public static ResponseBean<String> success() {
        return success("success");
    }

    public static <T> ResponseBean<T> success(T data) {
        return success(0, "操作成功", data);
    }

    public static <T> ResponseBean<T> success(int code, String message, T data) {
        return ResponseBean.<T>builder()
                .responseCode(code)
                .responseMsg(message)
                .isSuccess(true)
                .data(data)
                .build();
    }

    public static ResponseBean<String> error() {
        return error(-1);
    }

    public static ResponseBean<String> error(int code) {
        return error(code, "error");
    }

    public static <T> ResponseBean<T> error(T data) {
        return error(-1, data);
    }

    public static <T> ResponseBean<T> error(int code, T data) {
        return error(code, "操作失败", data);

    }

    public static <T> ResponseBean<T> error(int code, String message, T data) {
        return ResponseBean.<T>builder()
                .responseCode(code)
                .responseMsg(message)
                .isSuccess(false)
                .data(data)
                .build();
    }

}
