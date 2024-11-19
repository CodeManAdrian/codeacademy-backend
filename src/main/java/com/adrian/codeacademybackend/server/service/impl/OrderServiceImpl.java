package com.adrian.codeacademybackend.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.adrian.codeacademybackend.model.entity.Order;
import com.adrian.codeacademybackend.server.service.OrderService;
import com.adrian.codeacademybackend.server.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 28945
* @description 针对表【order(订单表)】的数据库操作Service实现
* @createDate 2024-11-18 12:47:01
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




