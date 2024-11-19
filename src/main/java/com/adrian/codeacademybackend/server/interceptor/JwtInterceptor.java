package com.adrian.codeacademybackend.server.interceptor;

import com.adrian.codeacademybackend.common.constant.JwtClaimsConstant;
import com.adrian.codeacademybackend.common.context.BaseContext;
import com.adrian.codeacademybackend.common.properties.JwtProperties;
import com.adrian.codeacademybackend.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Date: 2024/11/18 19:11
 * Author: Adrian
 * Version: 1.0
 * Description: jwt令牌校验的拦截器
 * */
@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    // Jwt配置
    @Autowired
    private JwtProperties jwtProperties;


    /**
     * 请求到达处理器方法之前执行自定义的预处理逻辑
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            // 当前拦截到的不是Controller方法,直接放行
            return true;
        }

        // 获取请求头中的令牌
        String token = request.getHeader(jwtProperties.getTokenName());

        // 校验令牌
        try {
            log.info("jwt校验:{}", token);
            // 调用jwt工具类
            Claims claims = JwtUtil.verifyToken(jwtProperties.getSecretKey(), token);
            Long userId = Long.valueOf(claims.get(JwtClaimsConstant.ACCOUNT).toString());
            String userRole = claims.get(JwtClaimsConstant.USER_ROLE).toString();
            BaseContext.put("userId", userId);
            BaseContext.put("userRole", userRole);
            log.info("当前用户id:{}", userId);
            // 通过,放行
            return true;
        } catch (Exception e) {
            // 不通过,响应401状态码,表示无权限
            response.setStatus(401);
            return false;
        }
    }
}
