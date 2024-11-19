package com.adrian.codeacademybackend.server.controller;

import com.adrian.codeacademybackend.common.constant.JwtClaimsConstant;
import com.adrian.codeacademybackend.common.properties.JwtProperties;
import com.adrian.codeacademybackend.common.result.Result;
import com.adrian.codeacademybackend.common.utils.JwtUtil;
import com.adrian.codeacademybackend.model.dto.LoginDTO;
import com.adrian.codeacademybackend.model.dto.RegisterDTO;
import com.adrian.codeacademybackend.model.entity.User;
import com.adrian.codeacademybackend.model.vo.LoginUserVO;
import com.adrian.codeacademybackend.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
 * Date: 2024/11/18 14:29
 * Author: Adrian
 * Version: 1.0
 * Description: 用户管理接口
 * */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;


    /**
     * 测试是否拦截登录和注册以外的路径
     *
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        return "成功";
    }


    /**
     * 用户注册
     *
     * @param RegisterDTO
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册")
    public Result<String> register(@RequestBody RegisterDTO registerDTO) {
        log.info("用户注册：{}", registerDTO);
        userService.register(registerDTO);
        return Result.success();
    }


    /**
     * 用户登录
     *
     * @param RegisterDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result<LoginUserVO> login(@RequestBody LoginDTO loginDTO) {
        log.info("用户登录：{}", loginDTO);
        User loginUser = userService.login(loginDTO);

        // 把登录后,收集用户的账号和用户角色信息
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ROLE, loginUser.getId());
        claims.put(JwtClaimsConstant.ACCOUNT, loginUser.getAccount());
        // 然后放入jwt的Payload(有效载荷),最后生成token令牌
        String token = JwtUtil.createToken(
                jwtProperties.getSecretKey(),
                jwtProperties.getTimeToLive(),
                claims
        );

        LoginUserVO loginUserVO = LoginUserVO.builder()
                .account(loginUser.getAccount())
                .role(loginUser.getRole())
                .token(token)
                .build();


        return Result.success(loginUserVO);
    }


}
