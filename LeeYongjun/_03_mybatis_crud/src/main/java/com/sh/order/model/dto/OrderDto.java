package com.sh.order.model.dto;

import com.sh.menu.model.dto.MenuDto;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor // 기본생성자
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
     * 1:N관계를 객체지향에 표현하는 방식
     */
    private List<OrderMenuDto> orderMenuList;
}
