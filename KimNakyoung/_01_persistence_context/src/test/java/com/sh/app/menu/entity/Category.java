package com.sh.app.menu.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long categoryCode;
    private String categoryName;
    private Long regCategoryCode;
}
