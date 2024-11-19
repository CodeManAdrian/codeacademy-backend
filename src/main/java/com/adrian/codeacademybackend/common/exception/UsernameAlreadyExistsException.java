package com.adrian.codeacademybackend.common.exception;

/*
 * Date: 2024/11/19 17:36
 * Author: Adrian
 * Version: 1.0
 * Description:
 * */
public class UsernameAlreadyExistsException extends BaseException {
    public UsernameAlreadyExistsException() {
    }

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}
