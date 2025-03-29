package com.sh.app.category.dto;

import com.sh.app.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
    private Long categoryCode;
    private String categoryName;
    private Long refCategoryCode;

    /**
     * Cateogry Entity를 DTO로 변환하는 static 메소드
     * @param category
     * @return
     */
    public static CategoryResponseDto fromCategory(Category category) {
        return new CategoryResponseDto(
                    category.getCategoryCode(), 
                    category.getCategoryName(), 
                    category.getRefCategoryCode());
    }
}
