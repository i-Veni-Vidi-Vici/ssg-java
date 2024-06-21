package com.sh._02_transaction.order.model.dao;

import com.sh._02_transaction.order.model.dto.OrderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    @DisplayName("OrderMapper 빈 확인")
    void test1() {
        // given
        // when
        System.out.println(orderMapper);
        // then
        assertThat(orderMapper).isNotNull();
    }

    @Test
    @DisplayName("")
    void test2() {
        // given
        LocalDate orderDate = LocalDate.now();
        LocalTime orderTime = LocalTime.now();
        int totalOrderPrice = 100_000;
        OrderDto orderDto = new OrderDto(null, orderDate, orderTime, totalOrderPrice, null);
        // when
        int result = orderMapper.insertOrder(orderDto);
        // then
        assertThat(result).isEqualTo(1);
        assertThat(orderDto.getOrderCode())
                .isNotZero();
    }
}