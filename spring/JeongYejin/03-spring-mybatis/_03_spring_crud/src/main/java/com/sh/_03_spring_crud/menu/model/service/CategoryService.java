package com.sh._03_spring_crud.menu.model.service;

import com.sh._03_spring_crud.menu.model.dao.CategoryMapper;
import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> findAll() {
        return categoryMapper.findAll();
    }
}
