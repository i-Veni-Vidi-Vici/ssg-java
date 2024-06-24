package com.sh._04_paging.order.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderMenuDto {
    private Long orderCode;
    private Long menuCode;
    private int orderAmount;

}
