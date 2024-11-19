package com.adrian.codeacademybackend.server.mapper;

import com.adrian.codeacademybackend.model.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 28945
* @description 针对表【post(帖子表)】的数据库操作Mapper
* @createDate 2024-11-18 12:47:01
* @Entity com.adrian.codeacademybackend.model.entity.Post
*/
@Mapper
public interface PostMapper extends BaseMapper<Post> {

}




