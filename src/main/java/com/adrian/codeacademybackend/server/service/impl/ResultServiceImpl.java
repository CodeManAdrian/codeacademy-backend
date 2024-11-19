package com.adrian.codeacademybackend.server.service.impl;

import com.adrian.codeacademybackend.server.service.ResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.adrian.codeacademybackend.model.entity.Result;
import com.adrian.codeacademybackend.server.mapper.ResultMapper;
import org.springframework.stereotype.Service;

/**
* @author 28945
* @description 针对表【result(评测结果表)】的数据库操作Service实现
* @createDate 2024-11-18 12:47:01
*/
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Result>
    implements ResultService {

}




