package com.sh.app.menu.repository.jpql;

import static org.assertj.core.api.Assertions.assertThat;

import com.sh.app.menu.dto.IMenuCategoryResponseDto;
import com.sh.app.menu.dto.MenuCategoryResponseDto;
import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.repository.MenuRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
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
        System.out.println(dto);  // org.springframework.data.jpa.repository.query.AbstractJpaQuery$TupleConverter$TupleBackedMap@5ca8157c
        // then
        assertThat(dto).isNotNull()
                .satisfies(
                        (_dto) -> assertThat(_dto.getMenuCode()).isEqualTo(menuCode),
                        (_dto) -> assertThat(_dto.getMenuName()).isNotNull(),
                        (_dto) -> assertThat(_dto.getCategoryName()).isNotNull()
                );
    }

}
