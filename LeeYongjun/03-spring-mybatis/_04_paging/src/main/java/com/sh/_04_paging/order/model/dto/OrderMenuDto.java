package com.sh._04_paging.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 주문데이터가 생성될때 n개의 주문메뉴데이터도 함께 생성된다.
 * 이를 데이터의 생명주기가 같다라고 하며
 * 같은 자바패키지에서 관리하게 된다.
 * (테이블당 패키지가 하나씩 꼭 존재해야 하는 것은 아니다.)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderMenuDto {
    private Long orderCode;
    private Long menuCode;
    private int orderAmount;
}
