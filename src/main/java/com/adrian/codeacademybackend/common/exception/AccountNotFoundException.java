package com.adrian.codeacademybackend.common.exception;

/*
 * Date: 2024/11/19 19:48
 * Author: Adrian
 * Version: 1.0
 * Description:
 * */
public class AccountNotFoundException extends BaseException{

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
