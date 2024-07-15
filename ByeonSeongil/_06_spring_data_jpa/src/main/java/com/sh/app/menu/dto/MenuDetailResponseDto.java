package com.sh.app.menu.dto;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDetailResponseDto {
    private Long menuCode;
    private String menuName;
    private int menuPrice;
    private Long categoryCode;
    private OrderableStatus orderableStatus;

    public static MenuDetailResponseDto fromMenu(Menu menu){
        return new MenuDetailResponseDto(
                menu.getMenuCode(),
                menu.getMenuName(),
                menu.getMenuPrice(),
                menu.getCategoryCode(),
                menu.getOrderableStatus()
        );
    }
}
