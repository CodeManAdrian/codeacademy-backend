package com.adrian.codeacademybackend.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/*
 * Date: 2024/11/19 15:46
 * Author: Adrian
 * Version: 1.0
 * Description:
 * */
@Data
@ApiModel(description = "用户注册时传递的数据模型")
public class RegisterDTO {
    /**
     * 用户ID(账号)
     */
    private Long account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮件
     */
    private String email;
}
