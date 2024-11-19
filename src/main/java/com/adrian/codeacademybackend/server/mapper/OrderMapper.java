package com.adrian.codeacademybackend.server.mapper;

import com.adrian.codeacademybackend.model.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 28945
* @description 针对表【order(订单表)】的数据库操作Mapper
* @createDate 2024-11-18 12:47:01
* @Entity com.adrian.codeacademybackend.model.entity.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}




