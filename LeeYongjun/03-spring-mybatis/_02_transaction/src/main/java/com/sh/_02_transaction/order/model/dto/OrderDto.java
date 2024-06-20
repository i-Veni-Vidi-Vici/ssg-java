package com.sh._02_transaction.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderCode;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private int totalOrderPrice;
    private List<OrderMenuDto> orderMenuDtos;
}
