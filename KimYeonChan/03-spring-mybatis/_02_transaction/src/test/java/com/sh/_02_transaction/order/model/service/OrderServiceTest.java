package com.sh._02_transaction.order.model.service;

import com.sh._02_transaction.order.model.dto.OrderDto;
import com.sh._02_transaction.order.model.dto.OrderMenuDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderServiceTest {
    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("")
    void test1() {
        // given: 현재 OrderMenuDto 객체에는 orderCode 가 설정되어 있지 않다. OrderDto 등록 후 처리 가능하다.
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDate(LocalDate.now());
        orderDto.setOrderTime(LocalTime.now());
        orderDto.setTotalOrderPrice(24_000);
        orderDto.setOrderMenuDtos(List.of(
                new OrderMenuDto(null,1L, 2),
                new OrderMenuDto(null,2L, 3)
        ));
        // when
        int result = orderService.createOrder(orderDto);
        // then
        assertThat(result)
                .isPositive();
    }

    /**
     * n 건의 DML 중 한건이라도 예외가 덩져지면, 전체 DML 은 rollback 처리되어야 하고,
     * controller 로 다시 예외가 던져져야 한다.
     */
    @Test
    @DisplayName("주문 등록 오류 트랜잭션")
    void test2() {
        // given: 현재 OrderMenuDto 객체에는 orderCode 가 설정되어 있지 않다. OrderDto 등록 후 처리 가능하다.
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDate(LocalDate.now());
        orderDto.setOrderTime(LocalTime.now());
        orderDto.setTotalOrderPrice(24_000);
        orderDto.setOrderMenuDtos(List.of(
                new OrderMenuDto(null,10L, 2),
                new OrderMenuDto(null,2_000L, 3)
        ));
        // when
        assertThatThrownBy(() -> {
            int result = orderService.createOrder(orderDto);
        }).isInstanceOf(Exception.class);
        // then
    }
}