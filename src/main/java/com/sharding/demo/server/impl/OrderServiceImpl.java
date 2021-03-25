package com.sharding.demo.server.impl;

import com.sharding.demo.model.Order;
import com.sharding.demo.dao.OrderMapper;
import com.sharding.demo.server.IOrderService;
import com.sharding.demo.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lgh
 * @since 2021-03-24
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, Order> implements IOrderService {

}
