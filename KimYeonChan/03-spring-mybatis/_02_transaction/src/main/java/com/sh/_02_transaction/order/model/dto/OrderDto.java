package com.sh._02_transaction.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * 주문 데이터가 생성될때, n개의 주문 메뉴 데이터도 함께 생성된다.
 * 이를 데이터의 생명주기가 같다라고 하며,
 * 같은 자바 패키지에서 관리하게 된다.
 * (테이블당 패키지가 하나씨가 꼭 존재해야하는 것은 아니다.)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long orderCode;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private int totalOrderPrice;

    private List<OrderMenuDto> orderMenuDtos;
}
