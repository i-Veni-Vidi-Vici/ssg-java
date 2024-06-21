package com.sh._03_spring_crud.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto2 {
    private Long menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String categoryName;
    private OrderableStatus orderableStatus;
}
