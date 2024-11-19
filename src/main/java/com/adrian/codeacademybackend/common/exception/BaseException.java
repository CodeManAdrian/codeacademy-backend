package com.adrian.codeacademybackend.common.exception;

/*
 * Date: 2024/11/17 20:01
 * Author: Adrian
 * Version: 1.0
 * Description:
 * */
public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
    }
}