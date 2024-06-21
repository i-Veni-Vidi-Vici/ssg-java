package com.sh._03_spring_crud.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuCategoryDto {
    private Long menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String categoryName; // 스칼라서브쿼리로 값대입
    private OrderableStatus orderableStatus;
    private CategoryDto categoryDto;
}
