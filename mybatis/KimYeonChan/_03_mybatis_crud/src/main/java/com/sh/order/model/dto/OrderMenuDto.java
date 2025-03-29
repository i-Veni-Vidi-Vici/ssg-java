package com.sh.order.model.dto;

import com.sh.menu.model.dto.MenuDto;
import lombok.AllArgsConstructor;
import lombok.Data;

// @RequiredArgsConstructor: final 생성자
// @NoArgsConstructor // 기본생성자
// @AllArgsConstructor // 모든 매개인자 생성자
// @Getter
// @Setter
// @ToString
// @Data
@Data
@AllArgsConstructor
public class OrderMenuDto {
    private int orderCode;
    private int menuCode;
    private int orderAmount;

    private MenuDto Menu;
}