package com.sh.app.menu.dto;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuRegistRequestDto {
    private String menuName;
    private int menuPrice;
    private Long categoryCode;
    private OrderableStatus orderableStatus;

    public Menu toMenu(){
        return Menu.builder()
                .menuName(this.menuName)
                .menuPrice(this.menuPrice)
                .categoryCode(this.categoryCode)
                .orderableStatus(this.orderableStatus)
                .build();
    }
}
