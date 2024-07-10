package com.sh._03_spring_crud.menu.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class MenuCategoryNameDto extends MenuDto {
    private String categoryName; // 스칼라서브쿼리로 값대입

    public MenuCategoryNameDto(Long menuCode, String menuName, int menuPrice, int categoryCode, OrderableStatus orderableStatus, String categoryName) {
        super(menuCode, menuName, menuPrice, categoryCode, orderableStatus);
        this.categoryName = categoryName;
    }
}
