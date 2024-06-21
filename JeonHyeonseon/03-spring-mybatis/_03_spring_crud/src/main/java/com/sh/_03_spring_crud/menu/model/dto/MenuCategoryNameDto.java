package com.sh._03_spring_crud.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class MenuCategoryNameDto extends MenuDto{
    private String categoryName; // 스칼라 서브쿼리로 값대입

    // 부모필드(MenuDto)까지 포함해서 생성자를 하나 만들었음.
    public MenuCategoryNameDto(Long menuCode, String menuName, int menuPrice, int categoryCode, OrderableStatus orderableStatus, String categoryName) {
        super(menuCode, menuName, menuPrice, categoryCode, orderableStatus);
        this.categoryName = categoryName;
    }
}
