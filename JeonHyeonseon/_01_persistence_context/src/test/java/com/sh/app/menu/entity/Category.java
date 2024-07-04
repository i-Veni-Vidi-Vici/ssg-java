package com.sh.app.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Long CategoryCode;
    private String categoryName;
    private Long refCategoryCode;
}
