package com.sh._03_spring_crud.menu.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 롬복이 상속간의 생성자까지는 안만들어줌
public class MenuCategoryNameDto extends  MenuDto{
    private String categoryName; // 스칼라 서브 쿼리로 값 대입

    public MenuCategoryNameDto(Long menuCode, String menuName, int menuPrice, int categoryCode, OrderableStatus orderableStatus, String categoryName) {
        super(menuCode, menuName, menuPrice, categoryCode, orderableStatus);
        this.categoryName = categoryName;
    }
}
