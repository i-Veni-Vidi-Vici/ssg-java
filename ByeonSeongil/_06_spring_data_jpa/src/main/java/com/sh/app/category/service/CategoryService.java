package com.sh.app.category.service;

import com.sh.app.category.dto.CategoryResponseDto;
import com.sh.app.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    /**
     * 조회된 Entity를 컨트롤러에 그대로 전달하지 않고,
     * DTO객체로 변환해서 반환한다.
     * @return
     */
    public List<CategoryResponseDto> findByRefCategoryCodeIsNotNull() {
        // List<Category> -> List<CategoryResponseDto>
        return categoryRepository.findByRefCategoryCodeIsNotNull().stream()
                .map(CategoryResponseDto::fromCategory)
                .toList();
    }
}
