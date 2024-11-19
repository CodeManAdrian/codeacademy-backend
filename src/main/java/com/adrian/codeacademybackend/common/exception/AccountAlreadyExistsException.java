package com.adrian.codeacademybackend.common.exception;

/*
 * Date: 2024/11/17 20:00
 * Author: Adrian
 * Version: 1.0
 * Description:
 * */
public class AccountAlreadyExistsException extends BaseException{

    public AccountAlreadyExistsException() {
    }

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
