package com.adrian.codeacademybackend.server.mapper;

import com.adrian.codeacademybackend.model.entity.Result;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 28945
* @description 针对表【result(评测结果表)】的数据库操作Mapper
* @createDate 2024-11-18 12:47:01
* @Entity com.adrian.codeacademybackend.model.entity.Result
*/
@Mapper
public interface ResultMapper extends BaseMapper<Result> {

}




