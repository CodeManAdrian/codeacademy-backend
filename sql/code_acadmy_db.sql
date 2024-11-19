-- 新建数据库
DROP DATABASE IF EXISTS code_academy_db;

CREATE DATABASE IF NOT EXISTS code_academy_db;

USE code_academy_db;

-- 用户表
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id             BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    account        BIGINT       NOT NULL UNIQUE COMMENT '账号',
    username       VARCHAR(50)  NOT NULL UNIQUE COLLATE utf8_bin COMMENT '用户名',
    password       VARCHAR(255) NOT NULL COMMENT '密码（MD5存储）',
    email          VARCHAR(100) NULL COMMENT '电子邮件',
    role           INT      DEFAULT 0 COMMENT '用户角色（0-普通用户 、 1-VIP用户 、 2-管理员）',
    status         TINYINT  DEFAULT 1 COMMENT '用户状态（0-禁用，1-正常）',
    vip_expiration DATE     DEFAULT NULL COMMENT 'VIP到期时间',
    created_at     DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    updated_at     DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '用户表';

-- 题目表
DROP TABLE IF EXISTS question;

CREATE TABLE question
(
    id           BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    question_id  BIGINT       NOT NULL UNIQUE COMMENT '题目ID',
    account      BIGINT       NOT NULL COMMENT '出题人账号',
    title        VARCHAR(512) NOT NULL DEFAULT '' COMMENT '题目标题',
    content      TEXT         NULL COMMENT '题目内容',
    tags         TEXT         NULL     DEFAULT NULL COMMENT '标签列表（JSON 数组）',
    answer       TEXT         NULL COMMENT '题目答案',
    submit_num   INT          NOT NULL DEFAULT 0 COMMENT '题目提交数',
    accepted_num INT          NOT NULL DEFAULT 0 COMMENT '题目通过数',
    judge_case   TEXT         NULL COMMENT '判题用例 (JSON 数组)',
    judge_config TEXT         NULL COMMENT '判题配置 (JSON 对象)',
    is_visible   TINYINT               DEFAULT 0 COMMENT '是否可见（0-不可见，1-可见）',
    create_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_questionId` (id ASC) USING BTREE,
    INDEX `idx_userId` (account ASC) USING BTREE
) COMMENT = '题目表';

-- 评测结果表
DROP TABLE IF EXISTS result;

CREATE TABLE result
(
    id          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    question_id BIGINT       NOT NULL COMMENT '题目ID',
    account     BIGINT       NOT NULL COMMENT '答题用户账号',
    language    VARCHAR(128) NOT NULL COMMENT '编程语言',
    code        TEXT         NOT NULL COMMENT '答题用户代码',
    judge_info  TEXT         NULL COMMENT '判题信息 (json 对象)',
    status      INT          NOT NULL DEFAULT 0 COMMENT '判题状态 (0 - 待判题 、 1 - 判题中 、 2 - 成功 、 3 - 失败)',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_questionId (question_id ASC) USING BTREE,
    INDEX idx_userId (account ASC) USING BTREE
) COMMENT = '评测结果表';

-- 资源表
DROP TABLE IF EXISTS resources;

CREATE TABLE resources
(
    resources_id      BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    account           BIGINT       NOT NULL COMMENT '发布者账号',
    title             VARCHAR(100) NOT NULL COMMENT '资源标题',
    link              VARCHAR(255) COMMENT '资源链接',
    description       TEXT COMMENT '资源描述',
    is_vip_accessible TINYINT(1) DEFAULT 0 COMMENT '是否仅VIP用户可访问： 0 - 否 、 1 - 是',
    is_visible        TINYINT    DEFAULT 0 COMMENT '是否可见（0-不可见，1-可见）',
    created_at        DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at        DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '资源表';

-- 帖子表
DROP TABLE IF EXISTS post;

CREATE TABLE post
(
    post_id   BIGINT        NOT NULL AUTO_INCREMENT COMMENT '主键',
    title     VARCHAR(512)  NULL     DEFAULT NULL COMMENT '标题',
    content   TEXT          NULL COMMENT '内容',
    tags      VARCHAR(1024) NULL     DEFAULT NULL COMMENT '标签列表（json 数组）',
    thumb_num INT           NOT NULL DEFAULT 0 COMMENT '点赞数',
    account   BIGINT        NOT NULL COMMENT '用户账号',
    create_at DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_at DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (post_id) USING BTREE,
    INDEX idx_account (account ASC) USING BTREE
) ENGINE = InnoDB COMMENT = '帖子表'
  ROW_FORMAT = DYNAMIC;

-- 订单表
DROP TABLE IF EXISTS `order`;

CREATE TABLE `order`
(
    id         INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    order_id   BIGINT         NOT NULL COMMENT '订单ID',
    account    BIGINT         NOT NULL COMMENT '账号',
    amount     DECIMAL(10, 2) NOT NULL COMMENT '支付金额',
    status     INT      DEFAULT 0 COMMENT '支付状态（0 - 待支付 、 1 - 已支付 、 2 - 支付失败）',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT '订单表';
