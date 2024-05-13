package com.sh.order.controller;

import com.sh.common.ErrorView;
import com.sh.common.error.ErrorCode;
import com.sh.order.model.CreateOrderTransactionException;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.service.OrderService;
import com.sh.order.view.OrderResultView;

import java.util.PrimitiveIterator;

import static com.sh.common.error.ErrorCode.CREATE_ORDER_ERROR;

public class OrderController {
    // 서비스한테 시키는 놈 = 그걸 실행자에게 반환 하거나, 바로 실행하기도 한다
    private OrderService orderService=new OrderService();

    public void createOrder(OrderDto orderDto) {
        // 그 장바구니와 장바구니의 주문코드, 주문 날짜, 주문 시간, 총 금액이 존재한다
        try {
            int result = orderService.createOrder(orderDto);
            OrderResultView.displayResult("주문", result);
        }
        catch (CreateOrderTransactionException e)
        {
            //트랜잭션 에러는  여기서 처리
            ErrorView.displayError(e.getErrorCode());
        }
        catch (Exception e)
        {
            // 그 외에 에러는 여기서 처리
            // 예외로깅(디버깅)
            //e.printStackTrace();//지금은 콘솔이니깐 콘솔에 보이는데, 나중에는 별도의 파일에 기록한다
            // 사용자 에러메세지 처리
            ErrorView.displayError(ErrorCode.CREATE_ORDER_ERROR);
        }

    }
}
