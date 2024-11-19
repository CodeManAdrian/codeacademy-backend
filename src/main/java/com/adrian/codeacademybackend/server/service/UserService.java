package com.adrian.codeacademybackend.server.service;

import com.adrian.codeacademybackend.model.dto.LoginDTO;
import com.adrian.codeacademybackend.model.dto.RegisterDTO;
import com.adrian.codeacademybackend.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 28945
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2024-11-18 12:47:02
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param registerDTO
     */
    void register(RegisterDTO registerDTO);

    /**
     * 用户登录
     *
     * @param loginDTO
     * @return
     */
    User login(LoginDTO loginDTO);
}
