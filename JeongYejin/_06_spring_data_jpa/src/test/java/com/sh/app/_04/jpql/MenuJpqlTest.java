package com.sh.app._04.jpql;

import com.sh.app.menu.dto.IMenuCategoryResponseDto;
import com.sh.app.menu.dto.MenuCategoryResponseDto;
import com.sh.app.menu.repository.MenuRepository;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MenuJpqlTest {
    @Autowired
    private MenuRepository menuRepository;

    @Test
    @DisplayName("Menu-Category 조회")
    void test1() {
        // given
        Long menuCode = 20L;
        // when
        MenuCategoryResponseDto dto = menuRepository.findMenuAndCategory(menuCode);
        /**
         * Hibernate:
         *     select
         *         m1_0.menu_code,
         *         m1_0.menu_name,
         *         c1_0.category_name
         *     from
         *         tbl_menu m1_0
         *     left join
         *         tbl_category c1_0
         *             on m1_0.category_code=c1_0.category_code
         *     where
         *         m1_0.menu_code=?
         */
        System.out.println(dto);
        // then
        assertThat(dto).isNotNull()
                .satisfies(
                        (_dto) -> assertThat(_dto.getMenuCode()).isEqualTo(menuCode),
                        (_dto) -> assertThat(_dto.getMenuName()).isNotNull(),
                        (_dto) -> assertThat(_dto.getCategoryName()).isNotNull()
                );
    }

    @Test
    @DisplayName("Menu-Category 조회 - NativeQuery + 인터페이스기반 DTO")
    void test2() {
        // given
        Long menuCode = 20L;
        // when
        IMenuCategoryResponseDto dto = menuRepository.findMenuAndCategoryWithSQL(menuCode);
        /**
         * Hibernate:
         *     select
         *         menu_code "menuCode",
         *         menu_name "menuName",
         *         (select
         *             category_name
         *         from
         *             tbl_category
         *         where
         *             category_code = m.category_code) "categoryName"
         *     from
         *         tbl_menu m
         *     where
         *         menu_code = ?
         */
        System.out.println(dto);
        // then
        assertThat(dto).isNotNull()
                .satisfies(
                        (_dto) -> assertThat(_dto.getMenuCode()).isEqualTo(menuCode),
                        (_dto) -> assertThat(_dto.getMenuName()).isNotNull(),
                        (_dto) -> assertThat(_dto.getCategoryName()).isNotNull()
                );
    }
}
