package com.sh._02_transaction.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * 주문데이터가 생성될때, n개의 주문메뉴 데이터도 함께 생성됨
 * 이를 (주문-주문메뉴)데이터의 생명주기가 같다라고 하며, 같은 자바 패키지에서 관리하게 됨
 * (테이블 당 패키지가 하나씩 꼭 존재해야 하는 것은 아님)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long orderCode;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private int totalOrderPrice;
    // db에 컬럼이 존재하지는 않지만, Java App의 원활한 흐름을 위해 1:N관계의 DTO객체 추가
    List<OrderMenuDto> orderMenuDtos;
}