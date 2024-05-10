package com.sh.order.model.dao;

import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;

public interface OrderMapper {
    int insertOrder(OrderDto orderDto); // order-mapper.xml의 insertOrder 쿼리와 대응
    int insertOrderMenu(OrderMenuDto orderMenuDto);
}
