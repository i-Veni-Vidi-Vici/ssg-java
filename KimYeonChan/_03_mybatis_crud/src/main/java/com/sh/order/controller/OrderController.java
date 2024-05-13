package com.sh.order.controller;

import com.sh.common.ErrorView;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.service.OrderService;
import com.sh.order.view.OrderResultView;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void createOrder(OrderDto orderDto) {
        try {
            int result = orderService.createOrder(orderDto);
            OrderResultView.displayResult("주문", result);
        }
        catch (Exception e) {
            // 예외 로깅(디버깅을 위해서)
            e.printStackTrace(); // 이후 별도의 파일에 오류 로그 기록
            // 사용자 에러 메세지 처리
            ErrorView.displayError("주문 중 오류 발생했습니다. 불편을 드려 죄송합니다.");
        }
    }
}
