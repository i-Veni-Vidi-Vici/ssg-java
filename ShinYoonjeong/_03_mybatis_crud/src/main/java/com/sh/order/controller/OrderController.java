package com.sh.order.controller;

import com.sh.common.ErrorView;
import com.sh.order.model.dto.OrderDto;
import com.sh.order.model.exception.CreatOrderTransactionException;
import com.sh.order.model.service.OrderService;
import com.sh.order.view.OrderResultView;

public class OrderController {
    private OrderService orderService = new OrderService();

    public void createOrder(OrderDto orderDto) {

        try{
            int result = orderService.createOrder(orderDto);
            OrderResultView.displayResult("주문", result);
        }catch (CreatOrderTransactionException e){
            e.printStackTrace();
            ErrorView.displayError(e.getErrorcode());

        }
        catch(Exception e){
            e.printStackTrace();
            ErrorView.displayError("메뉴 조회 중에 오류 발생");
        }
    }
}
