package com.sh._03_spring_crud.menu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private int categoryCode;
    private String categoryName;
    private Long refCategoryCode;
}
