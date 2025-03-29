package com.sh.order.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
// 아래 어노테이션, lombok 의존에서 가져왔다
@NoArgsConstructor// 기본 생성자
@AllArgsConstructor// 모든 매개인자 생성자
@Getter
@Setter
@ToString
public class OrderDto {
    // 그니깐 여기는
    // 오더 리스트 = 장바구니 개념이다
    // 그 장바구니는 주문코드, 주문 날짜, 주문 시간, 총 금액이 존재한다
    private int orderCode;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private int totalOrderPrice;

    /**
     * 1:N관계를 객체지향에 표현하는 방식
     * Lonbok
     */

    private List<OrderMenuDto> orderMenuList;
}
