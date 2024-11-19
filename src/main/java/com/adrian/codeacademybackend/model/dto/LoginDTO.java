package com.adrian.codeacademybackend.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/*
 * Date: 2024/11/19 18:25
 * Author: Adrian
 * Version: 1.0
 * Description:
 * */
@Data
@ApiModel(description = "用户登录时传递的数据模型")
public class LoginDTO {
    /**
     * 用户ID(账号)
     */
    private Long account;


    /**
     * 密码
     */
    private String password;


}
