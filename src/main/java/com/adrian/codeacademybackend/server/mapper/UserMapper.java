package com.adrian.codeacademybackend.server.mapper;

import com.adrian.codeacademybackend.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 28945
 * @description 针对表【user(用户表)】的数据库操作Mapper
 * @createDate 2024-11-18 12:47:02
 * @Entity com.adrian.codeacademybackend.model.entity.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据账号查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from code_academy_db.user where account = #{account}")
    User getByAccount(Long userId);


    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    @Select("select * from code_academy_db.user where username = #{username}")
    User getByUsername(String username);


}




