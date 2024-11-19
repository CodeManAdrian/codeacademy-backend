package com.adrian.codeacademybackend.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Date: 2024/11/19 20:05
 * Author: Adrian
 * Version: 1.0
 * Description:
 * */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户登录返回的数据格式")
public class LoginUserVO {

    @ApiModelProperty("用户账号")
    private Long account;

    @ApiModelProperty("用户角色")
    private Integer role;

    @ApiModelProperty("token令牌")
    private String token;
}
