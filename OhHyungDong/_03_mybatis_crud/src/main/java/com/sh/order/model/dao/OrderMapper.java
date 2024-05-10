package com.sh.order.model.dao;

import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;

public interface OrderMapper {

    int insertOrder(OrderDto orderDto);

    int insertOrderMenu(OrderMenuDto orderMenuDto);

    int countAll();

    OrderDto findByOrderCode(int orderCode);
}
