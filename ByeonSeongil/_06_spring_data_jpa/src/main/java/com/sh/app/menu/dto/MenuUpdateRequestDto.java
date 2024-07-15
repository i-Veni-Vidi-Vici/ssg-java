package com.sh.app.menu.dto;

import com.sh.app.menu.entity.OrderableStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuUpdateRequestDto {
    private Long menuCode;
    private String menuName;
    private int menuPrice;
    private Long categoryCode;
    private OrderableStatus orderableStatus;
}
