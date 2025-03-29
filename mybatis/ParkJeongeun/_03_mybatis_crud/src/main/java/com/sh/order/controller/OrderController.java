package com.sh.order.controller;

import com.sh.common.ErrorView;
import com.sh.common.error.ErrorCode;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.exception.CreateOrderTransactionException;
import com.sh.order.model.service.OrderService;
import com.sh.order.view.OrderResultView;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void createOrder(OrderDto orderDto) {
        try {
            int result = orderService.createOrder(orderDto);
            OrderResultView.displayResult("주문", result);
        } catch (CreateOrderTransactionException e){
            e.printStackTrace();
            ErrorView.displayError(e.getErrorCode());
        } catch (Exception e){
            // 예외로깅 (디버깅 목적)
            // e.printStackTrace(); // 현재는 콘솔에 출력되지만, 나중에는 별도 파일에 오류로그 기록
            // 사용자 에러메세지 처리
            ErrorView.displayError(ErrorCode.CREATE_ORDER_ERROR);
        }
    }
}
