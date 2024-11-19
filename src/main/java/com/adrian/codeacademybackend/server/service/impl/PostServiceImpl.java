package com.adrian.codeacademybackend.server.service.impl;

import com.adrian.codeacademybackend.server.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.adrian.codeacademybackend.model.entity.Post;
import com.adrian.codeacademybackend.server.mapper.PostMapper;
import org.springframework.stereotype.Service;

/**
* @author 28945
* @description 针对表【post(帖子表)】的数据库操作Service实现
* @createDate 2024-11-18 12:47:01
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService {

}




