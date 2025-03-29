package com.sh.order.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDto {
    private int orderCode;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private int totalOrderPrice;

    /**
     * 1:N관계를 객체지향에 표현하는 방식
     */
    private List<OrderMenuDto> orderMenuList;
}
