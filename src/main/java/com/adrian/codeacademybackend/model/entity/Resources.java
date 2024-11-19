package com.adrian.codeacademybackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 资源表
 * @TableName resources
 */
@TableName(value ="resources")
@Data
public class Resources implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long resourcesId;

    /**
     * 发布者账号
     */
    private Long account;

    /**
     * 资源标题
     */
    private String title;

    /**
     * 资源链接
     */
    private String link;

    /**
     * 资源描述
     */
    private String description;

    /**
     * 是否仅VIP用户可访问： 0 - 否 、 1 - 是
     */
    private Integer isVipAccessible;

    /**
     * 是否可见（0-不可见，1-可见）
     */
    private Integer isVisible;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}