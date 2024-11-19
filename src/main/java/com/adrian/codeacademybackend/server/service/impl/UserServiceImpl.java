package com.adrian.codeacademybackend.server.service.impl;

import com.adrian.codeacademybackend.common.constant.MessageConstant;
import com.adrian.codeacademybackend.common.constant.StatusConstant;
import com.adrian.codeacademybackend.common.exception.*;
import com.adrian.codeacademybackend.model.dto.LoginDTO;
import com.adrian.codeacademybackend.model.dto.RegisterDTO;
import com.adrian.codeacademybackend.model.entity.User;
import com.adrian.codeacademybackend.server.mapper.UserMapper;
import com.adrian.codeacademybackend.server.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author 28945
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2024-11-18 12:47:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param registerDTO
     */
    @Override
    public void register(RegisterDTO registerDTO) {

        String username = registerDTO.getUsername();
        Long account = registerDTO.getAccount();
        String password = registerDTO.getPassword();

        User user = userMapper.getByAccount(account);
        if (user != null) {
            // 账号已存在
            throw new AccountAlreadyExistsException(MessageConstant.ACCOUNT_ALREADY_EXISTS);
        }

        // 判断用户名是否已经存在
        user = userMapper.getByUsername(username);
        if (user != null) {
            // 用户名已被占用
            throw new UsernameAlreadyExistsException(MessageConstant.USERNAME_ALREADY_EXISTS);
        }

        // 对密码进行加密,然后重新给赋值给密码
        registerDTO.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));

        // 将用户注册信息进行拷贝
        User registerUser = new User();
        BeanUtils.copyProperties(registerDTO, registerUser);

        // 将注册用户信息存入数据库
        userMapper.insert(registerUser);


    }


    /**
     * 用户登录
     *
     * @param loginDTO
     * @return
     */
    @Override
    public User login(LoginDTO loginDTO) {
        Long account = loginDTO.getAccount();
        String password = loginDTO.getPassword();

        // 判断账号是否存在
        User user = userMapper.getByAccount(account);
        if (user == null) {
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }

        // 进行md5加密，然后再进行比对
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        // 密码比对
        if (!password.equals(user.getPassword())) {
            // 密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        if (user.getStatus() == StatusConstant.DISABLE) {
            // 账号被锁定
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        return user;
    }
}




