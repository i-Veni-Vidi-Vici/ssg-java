package com.sh.app._03.projection;

import jakarta.persistence.Entity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;


@Data
public class CategoryResponseDto {
    private Long categoryCode;
    private String categoryName;
    private Integer number; // 이건 의미 없음 123 그거 쓸라고 하는거임

}
