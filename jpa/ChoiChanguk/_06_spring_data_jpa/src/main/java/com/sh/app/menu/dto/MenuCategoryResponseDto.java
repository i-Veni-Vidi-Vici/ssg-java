package com.sh.app.menu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuCategoryResponseDto {
    private Long menuCode;
    private String menuName;
    private String categoryName;
}
