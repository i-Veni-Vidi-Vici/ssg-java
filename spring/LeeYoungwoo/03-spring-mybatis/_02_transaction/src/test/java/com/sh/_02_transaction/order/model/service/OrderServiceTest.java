package com.sh._02_transaction.order.model.service;

import com.sh._02_transaction.order.model.dto.OrderDto;
import com.sh._02_transaction.order.model.dto.OrderMenuDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLIntegrityConstraintViolationException;
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

    /**
     * controller에서 주문데이터를 인자로 createOrder를 호출한다.
     */
    @Test
    @DisplayName("주문 등록 트랜잭션")
    void test1() {
        // given : 현재 OrderMenuDto 객체에는 orderCode가 설정되어있지 않다. OrderDto 등록 후 처리가능하다.
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDate(LocalDate.now());
        orderDto.setOrderTime(LocalTime.now());
        orderDto.setTotalOrderPrice(24000);
        orderDto.setOrderMenuDtos(List.of(
                new OrderMenuDto(null, 1L, 2),
                new OrderMenuDto(null, 2L, 3)
        ));
        // when
        int result = orderService.createOrder(orderDto);
        // then
        assertThat(result).isPositive(); // 정상처리되었다면 양수가 반환되도록
    }

    /**
     * n건의 DML중 한건이라도 예외가 던져지면, 전체 DML은 rollback처리되어야 하고,
     * controller로 다시 예외가 던져져야 한다.
     */
    @Test
    @DisplayName("주문 등록 오류 트랜잭션")
    void test2() {
        // given : 현재 OrderMenuDto 객체에는 orderCode가 설정되어있지 않다. OrderDto 등록 후 처리가능하다.
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDate(LocalDate.now());
        orderDto.setOrderTime(LocalTime.now());
        orderDto.setTotalOrderPrice(33000);
        orderDto.setOrderMenuDtos(List.of(
                new OrderMenuDto(null, 10L, 2),
                new OrderMenuDto(null, 2000L, 3)
        ));
        // when & then
        // 실제 던져진 java.sql.SQLIntegrityConstraintViolationException (checked)예외를
        // spring은 org.springframework.dao.DataIntegrityViolationException (unchecked)예외로 전환해서 던진다.
        assertThatThrownBy(() -> {
            int result = orderService.createOrder(orderDto);
        })
                .isInstanceOf(SQLIntegrityConstraintViolationException.class)
                .hasMessageContaining("a foreign key constraint fails");

        // 예외로그를 확인해본다.
//        try {
//            int result = orderService.createOrder(orderDto);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }

}