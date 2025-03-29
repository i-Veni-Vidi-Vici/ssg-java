package com.sh.order.controller;

import com.sh.common.ErrorView;
import com.sh.common.error.ErrorCode;
import com.sh.menu.view.Resultview;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.exception.CreateOrderTransactionException;
import com.sh.order.model.service.OrderService;
import com.sh.order.view.OrderResultView;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void createOrder(OrderDto orderDto) {
        try { // 실행 코드를 try 블럭 안에 넣기
            int result = orderService.createOrder(orderDto);
            OrderResultView.displayResult("주문", result);
        } catch (CreateOrderTransactionException e) {
            e.printStackTrace();
            ErrorView.displayError(e.getErrorCode());
        } catch (Exception e) {
            //예외 로깅 (디버깅을 위해)
//            e.printStackTrace(); // 이후 별도의 파일에 오류 로그 기록 -> 사용자가 보게될 화면이 X
            //사용자 에러메세지 처리
            ErrorView.displayError(ErrorCode.CREATE_ORDER_ERROR); //ErrorView는 여러 패키지에서 쓰이므로 common 패키지에 위치
        }
    }
}
