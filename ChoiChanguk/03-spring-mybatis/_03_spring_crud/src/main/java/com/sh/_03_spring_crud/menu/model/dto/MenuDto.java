package com.sh._03_spring_crud.menu.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private Long menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private OrderableStatus orderableStatus;
}


