package com.adrian.codeacademybackend.server.mapper;

import com.adrian.codeacademybackend.model.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 28945
* @description 针对表【question(题目表)】的数据库操作Mapper
* @createDate 2024-11-18 12:47:01
* @Entity com.adrian.codeacademybackend.model.entity.Question
*/
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

}




