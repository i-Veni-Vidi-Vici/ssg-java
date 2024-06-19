package com.sh._02_handler_method;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    private Long id;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;
}