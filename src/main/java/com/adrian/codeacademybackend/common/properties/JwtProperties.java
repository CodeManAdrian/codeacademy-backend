package com.adrian.codeacademybackend.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * Date: 2024/11/18 15:01
 * Author: Adrian
 * Version: 1.0
 * Description:
 * */
@Component
@ConfigurationProperties(prefix = "properties.jwt")
@Data
public class JwtProperties {

    /**
     * 生成jwt令牌相关配置
     */
    private String secretKey;
    private long timeToLive;
    private String tokenName;


}
