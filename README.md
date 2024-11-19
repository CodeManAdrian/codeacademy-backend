# **代码学院系统开发文档**

***

## **一、文档说明**

* **文档介绍：** 该文档用于个人毕业设计，为方便开发而撰写的简易版开发文档，并非标准文档，仅供参考使用。
* **编写时间：** 2024年11月15日
* **作者：** Adrian

***

## **二、功能模块**

***

### 1. **用户管理模块**

***

* **用户注册：** 用户填写注册信息提交后，存储用户信息，新用户默认角色为**普通用户**。
* **用户登录：** 用户通过账号和密码进行登录，进入系统。
* **用户管理：** **管理员**对**用户表**进行查询、修改、删除的操作。
* **修改个人信息：** **用户**可以修改自己的个人资料。
* **角色管理：** 0 - 管理员, 1 - 普通用户, 2 - 会员用户, 3 - 出题人。

***

### 2. **题目管理模块**

***

* **题目的增删改查：**
    * **管理员**可以对题目进行添加、修改、查询、删除的操作。
    * **用户**只能对题目进行查询的操作。

***

### 3. **评测管理模块**

***

* **代码提交：** 用户根据题目要求，编写代码然后进行提交。
* **判题功能：** 系统通过给代码沙箱喂入用户代码以及判题配置、判题用例等，返回评测结果。

***

### 4. **帖子管理模块**

*** 

* **帖子的增删改查：**
    * 用户可以发表帖子、修改帖子、删除帖子和查询帖子。
    * 管理员可以对帖子进行删除。

***

### 5. **资源管理模块**

***

* **资源的增删改查：**
    * 用户可以发布资源（文件内容）、修改资源、查询资源以及删除资源。
    * 管理员可以删除资源。
* **访问权限：** 资源分为普通资源以及会员资源。

***

### 6. **支付模块**

***

* **支付接口：** 用户可以通过支付接口购买会员。
* **订单管理：** 记录用户的支付订单信息
* **用户角色管理：** 支付成功后的普通用户升级为会员用户。

***

## **三、数据库设计**

***

### **1. 新建code_academy_db数据库**

```sql
DROP DATABASE IF EXISTS code_academy_db;

CREATE DATABASE IF NOT EXISTS code_academy_db;   
```

***

### **2. 用户表user**

```sql
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id             BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    account        BIGINT       NOT NULL UNIQUE COMMENT '用户ID',
    username       VARCHAR(50)  NOT NULL UNIQUE COMMENT '用户名',
    password       VARCHAR(255) NOT NULL COMMENT '密码（MD5存储）',
    email          VARCHAR(100) NULL COMMENT '电子邮件',
    role           INT      DEFAULT 0 COMMENT '用户角色（0-普通用户 、 1-VIP用户 、 2-管理员）',
    status         TINYINT  DEFAULT 1 COMMENT '用户状态（0-禁用，1-正常）',
    vip_expiration DATE     DEFAULT NULL COMMENT 'VIP到期时间',
    created_at     DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
    updated_at     DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '用户表';
```

***

### **3. 题目表**

```sql
DROP TABLE IF EXISTS question;

CREATE TABLE question
(
    id           BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    question_id  BIGINT       NOT NULL UNIQUE COMMENT '题目ID',
    account      BIGINT       NOT NULL COMMENT '出题人ID',
    title        VARCHAR(512) NOT NULL DEFAULT '' COMMENT '题目标题',
    content      TEXT         NULL COMMENT '题目内容',
    tags         TEXT         NULL     DEFAULT NULL COMMENT '标签列表（JSON 数组）',
    answer       TEXT         NULL COMMENT '题目答案',
    submit_num   INT          NOT NULL DEFAULT 0 COMMENT '题目提交数',
    accepted_num INT          NOT NULL DEFAULT 0 COMMENT '题目通过数',
    judge_case   TEXT         NULL COMMENT '判题用例 (JSON 数组)',
    judge_config TEXT         NULL COMMENT '判题配置 (JSON 对象)',
    is_visible         TINYINT  DEFAULT 0 COMMENT '用户状态（0-禁用，1-正常）',
    create_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX `idx_questionId` (id ASC) USING BTREE,
    INDEX `idx_userId` (account ASC) USING BTREE
) COMMENT = '题目表';
```

***

### **4. 评测结果表**

```sql
DROP TABLE IF EXISTS result;

CREATE TABLE result
(
    id          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    question_id BIGINT       NOT NULL COMMENT '题目ID',
    account     BIGINT       NOT NULL COMMENT '答题用户ID',
    language    VARCHAR(128) NOT NULL COMMENT '编程语言',
    code        TEXT         NOT NULL COMMENT '答题用户代码',
    judge_info  TEXT         NULL COMMENT '判题信息 (json 对象)',
    status      INT          NOT NULL DEFAULT 0 COMMENT '判题状态 (0 - 待判题 、 1 - 判题中 、 2 - 成功 、 3 - 失败)',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_questionId (question_id ASC) USING BTREE,
    INDEX idx_userId (account ASC) USING BTREE
) COMMENT = '评测结果表';
```

***

### **5. 资源表**

```sql
DROP TABLE IF EXISTS resources;

CREATE TABLE resources
(
    resources_id      BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    account           BIGINT       NOT NULL COMMENT '发布者ID',
    title             VARCHAR(100) NOT NULL COMMENT '资源标题',
    link              VARCHAR(255) COMMENT '资源链接',
    description       TEXT COMMENT '资源描述',
    is_vip_accessible TINYINT(1) DEFAULT 0 COMMENT '是否仅VIP用户可访问： 0 - 否 、 1 - 是',
    is_visible         TINYINT  DEFAULT 0 COMMENT '用户状态（0-禁用，1-正常）',
    created_at        DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at        DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '资源表';
```

***

### **6. 帖子表**

```sql
DROP TABLE IF EXISTS post;

CREATE TABLE post
(
    post_id   BIGINT        NOT NULL AUTO_INCREMENT COMMENT '主键',
    title     VARCHAR(512)  NULL     DEFAULT NULL COMMENT '标题',
    content   TEXT          NULL COMMENT '内容',
    tags      VARCHAR(1024) NULL     DEFAULT NULL COMMENT '标签列表（json 数组）',
    thumb_num INT           NOT NULL DEFAULT 0 COMMENT '点赞数',
    account   BIGINT        NOT NULL COMMENT '创建用户ID',
    create_at DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_at DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (post_id) USING BTREE,
    INDEX idx_account (account ASC) USING BTREE
) ENGINE = InnoDB COMMENT = '帖子表'
  ROW_FORMAT = DYNAMIC;
```

***

### **7. 订单表**

```sql
DROP TABLE IF EXISTS `order`;

CREATE TABLE `order`
(

    id         INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
    order_id   BIGINT         NOT NULL COMMENT '订单ID',
    account    BIGINT         NOT NULL COMMENT '用户ID',
    amount     DECIMAL(10, 2) NOT NULL COMMENT '支付金额',
    status     INT      DEFAULT 0 COMMENT '支付状态（0 - 待支付 、 1 - 已支付 、 2 - 支付失败）',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) COMMENT '订单表';

```

***
**注意:**  
以上所有表不设置物理外键，而使用逻辑外键，意味着不依赖数据库的外键约束来强制数据完整性，而是通过应用程序代码实现表之间的关系验证。这样可以减少数据库的负担，提升性能，但需要开发者在应用层手动维护数据一致性，防止数据错误或不一致的情况发生。逻辑外键适用于对性能要求较高、数据关联灵活性较强的场景。

***

## **四、接口文档**

***

### **1. 用户管理接口**

#### **1.1 用户注册**

* **请求路径:** `POST /user/register`
* 请求参数:

  ```json
  {
    "userId": "100861001010001",
    "username": "Tom",
    "password": "123456",
    "email": "randomusertom@example.com"
  }
  ```

* 返回结果:

  成功:

  ```json
  {
    "code": 1,
    "message": "注册成功!",
    "data": null
  }
  ```

  失败:

  ```json
  {
    "code": 0,
    "message": "",
    "data": null
  }
  ```


