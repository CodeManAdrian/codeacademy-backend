package com.adrian.codeacademybackend.server.handler;

import com.adrian.codeacademybackend.common.exception.BaseException;
import com.adrian.codeacademybackend.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * Date: 2024/11/19 17:49
 * Author: Adrian
 * Version: 1.0
 * Description: 全局异常处理器，处理项目中抛出的业务异常
 * */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler
    public Result<String> exceptionHandler(BaseException e) {
        log.error("异常信息：{}", e.getMessage());
        return Result.error(e.getMessage());
    }
}
