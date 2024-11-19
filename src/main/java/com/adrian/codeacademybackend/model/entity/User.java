package com.adrian.codeacademybackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户账号
     */
    private Long account;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码（MD5存储）
     */
    private String password;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 用户角色（0-普通用户 、 1-VIP用户 、 2-管理员）
     */
    private Integer role;

    /**
     * 用户状态（0-禁用，1-正常）
     */
    private Integer status;

    /**
     * VIP到期时间
     */
    private Date vipExpiration;

    /**
     * 注册时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}