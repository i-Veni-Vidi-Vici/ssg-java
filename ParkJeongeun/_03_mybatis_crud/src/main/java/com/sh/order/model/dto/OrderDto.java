package com.sh.order.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 매개인자 생성자
@Getter
@Setter
@ToString
public class OrderDto {
    private int orderCode;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private int totalOrderPrice;

    /**
     * 1:N 관계를 객체지향에 표현하는 방식
     * 하나의 OrderDto는 N개의 OrderMenuDto를 가짐
     * - 1:1 관계는 일반 필드로 정의
     */
    private List<OrderMenuDto> orderMenuList;
}
