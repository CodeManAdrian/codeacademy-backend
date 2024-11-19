package com.adrian.codeacademybackend.common.result;

import lombok.Data;

/*
 * Date: 2024/11/17 15:07
 * Author: Adrian
 * Version: 1.0
 * Description:
 * 后端统一返回结果
 * @param <T>
 * */
@Data
public class Result<T> {

    // 编码：1成功，0和其它数字为失败
    private Integer code;

    // 错误信息
    private String message;

    // 数据
    private T data;


    // 成功,没有带数据返回
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    // 成功,带有数据返回
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.data = data;
        result.code = 1;
        return result;
    }

    // 失败,带有错误数据
    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.message = message;
        result.code = 0;
        return result;
    }


}
