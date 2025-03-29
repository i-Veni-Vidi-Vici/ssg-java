package com.sh.order.model.dao;

import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;

public interface OrderMapper {
    int insertOrder(OrderDto orderDto);
    int insertOrderMenu(OrderMenuDto orderMenuDto);

    int countAll(); // 추상메소드

    OrderDto findByOrderCode(int orderCode);
}
