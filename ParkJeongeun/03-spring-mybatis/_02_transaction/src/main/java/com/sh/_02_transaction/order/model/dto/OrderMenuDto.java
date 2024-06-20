package com.sh._02_transaction.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderMenuDto {
    private Long orderCode;
    private Long menuCode;
    private int orderAmount;
}