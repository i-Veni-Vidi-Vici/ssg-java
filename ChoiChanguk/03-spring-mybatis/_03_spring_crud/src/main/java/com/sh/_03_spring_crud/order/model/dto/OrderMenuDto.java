package com.sh._03_spring_crud.order.model.dto;


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
