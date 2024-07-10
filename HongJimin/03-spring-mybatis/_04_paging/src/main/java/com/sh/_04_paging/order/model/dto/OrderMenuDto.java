package com.sh._04_paging.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMenuDto {
    private Long orderCode;
    private Long menuCode;
    private int orderAmount;

}
