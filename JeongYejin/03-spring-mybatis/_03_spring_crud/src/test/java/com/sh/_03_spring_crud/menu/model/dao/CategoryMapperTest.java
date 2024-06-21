package com.sh._03_spring_crud.menu.model.dao;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import com.sh._03_spring_crud.menu.model.dto.OrderableStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    @DisplayName("카테고리 조회")
    void test1() {
        // given
        // when
        List<CategoryDto> categories = categoryMapper.findAll();
        // then
        assertThat(categories).isNotNull()
                .isNotEmpty()
                .allMatch((category) -> category != null)
                .allSatisfy((category) -> {
                    assertThat(category.getCategoryCode()).isNotZero();
                    assertThat(category.getCategoryName()).isNotNull();
                    assertThat(category.getRefCategoryCode()).isNotNull();
                });
    }
}