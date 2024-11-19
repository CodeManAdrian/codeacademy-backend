package com.adrian.codeacademybackend.server.service.impl;

import com.adrian.codeacademybackend.server.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.adrian.codeacademybackend.model.entity.Question;
import com.adrian.codeacademybackend.server.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author 28945
* @description 针对表【question(题目表)】的数据库操作Service实现
* @createDate 2024-11-18 12:47:01
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService {

}




