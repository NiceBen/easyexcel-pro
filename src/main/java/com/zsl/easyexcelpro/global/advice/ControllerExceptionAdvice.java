package com.zsl.easyexcelpro.global.advice;

import com.zsl.easyexcelpro.global.result.ResultCodeEnum;
import com.zsl.easyexcelpro.global.result.ResultVo;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler({BindException.class})
    public ResultVo MethodArgumentNotValidExceptionHandler(BindException e) {
        // 从异常对象中拿到 ObjectError 对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVo(ResultCodeEnum.VALIDATE_ERROR, objectError.getDefaultMessage());
    }
}
