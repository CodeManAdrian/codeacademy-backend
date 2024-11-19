package com.adrian.codeacademybackend.server.service.impl;

import com.adrian.codeacademybackend.server.service.ResourcesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.adrian.codeacademybackend.model.entity.Resources;
import com.adrian.codeacademybackend.server.mapper.ResourcesMapper;
import org.springframework.stereotype.Service;

/**
* @author 28945
* @description 针对表【resources(资源表)】的数据库操作Service实现
* @createDate 2024-11-18 12:47:01
*/
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources>
    implements ResourcesService {

}




