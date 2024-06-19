package com.sh._02_transaction.order.model.dao;

import com.sh._02_transaction.order.model.dto.OrderDto;
import com.sh._02_transaction.order.model.dto.OrderMenuDto;
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
    @DisplayName("OrderMapper빈 확인")
    void test() {
        // given
        // when
        System.out.println(orderMapper); // org.apache.ibatis.binding.MapperProxy@12a6e8ed
        // then
        assertThat(orderMapper).isNotNull();
    }

    @DisplayName("주문 등록")
    @Test
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
        assertThat(orderDto.getOrderCode()).isNotZero();
    }
    
    @Test
    @DisplayName("주문 메뉴 등록")
    void test3() {
        // given
        Long orderCode = 2L; // 존재하는 주문코드라고 가정
        Long menuCode = 1L; // 존재하는 메뉴코드라고 가정
        int orderAmount = 2;
        OrderMenuDto orderMenuDto = new OrderMenuDto(orderCode, menuCode, orderAmount);
        // when
        int result = orderMapper.insertOrderMenu(orderMenuDto);
        // then
        assertThat(result).isEqualTo(1);
    }
}