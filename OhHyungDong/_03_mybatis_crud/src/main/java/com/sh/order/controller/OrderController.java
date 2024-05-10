package com.sh.order.controller;

import com.sh.common.ErrorView;
import com.sh.common.error.ErrorCode;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.exception.CreateOrderTransactionException;
import com.sh.order.service.OrderService;
import com.sh.view.OrderResultView;

/**
 * 예외 로깅
 * - 사용자가 이해할 수 있는 메세지
 * - 정상적인 흐름 복구
 */
public class OrderController {

    OrderService orderService = new OrderService();

    public void createOrder(OrderDto orderDto) {
        try {
            int result = orderService.createOrder(orderDto);
            OrderResultView.displayResult("주문", result);
        } catch (CreateOrderTransactionException e) {
            e.printStackTrace();
            ErrorView.displayError(e.getErrorCode());
        } catch (Exception e) {
            //예외로깅(디버깅)
            //e.printStackTrace(); //이후 별도의 파일에 오류 로그 기록
            //사용자 에러메세지 처리
            ErrorView.displayError(ErrorCode.CREATE_ERROR_ERROR);
        }
    }
}
