package com.sh._04_paging.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuRegistDto {
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private OrderableStatus orderableStatus;

    public MenuDto toMenuDto() {
        return new MenuDto(null, this.menuName, this.menuPrice, this.categoryCode, this.orderableStatus);
    }
}
