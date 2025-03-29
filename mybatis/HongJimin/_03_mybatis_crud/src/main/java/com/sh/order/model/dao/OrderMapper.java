package com.sh.order.model.dao;

import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.dto.OrderMenuDto;

public interface OrderMapper { // order-mapper.xml의 파일에 있는 쿼리 코드를 실행하기 위한 메소드 정의
    int insertOrder(OrderDto orderDto);
    int insertOrderMenu(OrderMenuDto orderMenuDto);

    int countAll();

    OrderDto findByOrderCode(int orderCode);
}
