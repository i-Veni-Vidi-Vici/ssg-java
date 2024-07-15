package com.sh.app.menu.dto;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuListResponseDto {
    private Long menuCode;
    private String menuName;
    private int menuPrice;
    private Long categoryCode;
    private OrderableStatus orderableStatus;

    public static MenuListResponseDto fromMenu(Menu menu){
        return new MenuListResponseDto(
            menu.getMenuCode(),
            menu.getMenuName(),
            menu.getMenuPrice(),
            menu.getCategoryCode(),
            menu.getOrderableStatus()
        );
    }
}
