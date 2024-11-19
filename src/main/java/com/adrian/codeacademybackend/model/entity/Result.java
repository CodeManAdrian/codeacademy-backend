package com.adrian.codeacademybackend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 评测结果表
 * @TableName result
 */
@TableName(value ="result")
@Data
public class Result implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 题目ID
     */
    private Long questionId;

    /**
     * 答题用户账号
     */
    private Long account;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 答题用户代码
     */
    private String code;

    /**
     * 判题信息 (json 对象)
     */
    private String judgeInfo;

    /**
     * 判题状态 (0 - 待判题 、 1 - 判题中 、 2 - 成功 、 3 - 失败)
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}