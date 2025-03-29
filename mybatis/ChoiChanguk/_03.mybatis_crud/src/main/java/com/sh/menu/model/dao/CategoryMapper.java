package com.sh.menu.model.dao;

import com.sh.menu.model.dto.CategoryDto;

import java.util.List;

public interface CategoryMapper {
    List<CategoryDto> findAllCategory();
}
