package com.sh.app.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 인터페이스 기반의 DTO 프로젝션
 * - 하는 일은 DTO인데 인터페이스로 만듦
 */
public interface IMenuCategoryResponseDto {
    Long getMenuCode();
    String getMenuName();
    String getCategoryName();
}
