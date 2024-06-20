package com.sh._03_spring_crud.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 사용자의 입력값을 받아오는 Dto 받을 값만 정확하게 가져올 필드로 구성할것
public class MenuRegistDto {
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private OrderableStatus orderableStatus;

    public MenuDto toMenuDto() {
        return new MenuDto(null, this.menuName, this.menuPrice, this.categoryCode, this.orderableStatus);
    }
}
