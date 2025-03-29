package com.sh.menu.model.dao;

import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

class MenuMapperQueryTest {
    SqlSession sqlSession;
    MenuMapper menuMapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.menuMapper = this.sqlSession.getMapper(MenuMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.close();
    }

    /**
     * <pre>
     * 요구사항대로 테스트를 작성해야 한다.
     * given-when-then패턴을 적용해서 작성한다.
     * 준비-실행-검증 단계로 테스트를 작성한다.
     * </pre>
     */
    @DisplayName("메뉴 전체를 조회한다.")
    @Test
    void findAll() {
        // given
        // when
        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list);
        // then
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu != null)
                .allSatisfy((menu) -> {
                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    // nullable한 컬럼은 검증 제외
                    assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                        (status) -> "Y".equals(status),
                        (status) -> "N".equals(status)
                    );
                });
    }

    @DisplayName("메뉴코드로 한건의 메뉴를 조회할 수 있다.")
    @Test
    void findByMenuCode() {
        // given
        int menuCode = 1; // 존재하는 메뉴코드
        // when
        MenuDto menu = menuMapper.findByMenuCode(menuCode);
        // then
        assertThat(menu).isNotNull();
        assertThat(menu.getMenuCode()).isEqualTo(menuCode);
        assertThat(menu.getMenuName()).isNotNull();
        assertThat(menu.getMenuPrice()).isNotZero().isPositive();
        assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
            (status) -> "Y".equals(status),
            (status) -> "N".equals(status)
        );

        // satisfies(Consumer...)
        assertThat(menu).satisfies(
            (_menu) -> assertThat(_menu.getMenuCode()).isEqualTo(menuCode),
            (_menu) -> assertThat(_menu.getMenuName()).isNotNull(),
            (_menu) -> assertThat(_menu.getMenuPrice()).isNotZero().isPositive(),
            (_menu) -> assertThat(_menu.getOrderableStatus()).satisfiesAnyOf(
                    (status) -> "Y".equals(status),
                    (status) -> "N".equals(status)
            )
        );
    }

    @DisplayName("존재하지 않는 메뉴코드로 조회한 경우 null이 반환되어야 한다.")
    @Test
    void findByMenuCode2() {
        // given
        int menuCode = 123456789;
        // when
        MenuDto menu = menuMapper.findByMenuCode(menuCode);
        // then
        assertThat(menu).isNull();
    }

    @DisplayName("주어진 카테고리 코드의 메뉴만 조회할 수 있다.")
    @Test
    void findByCategoryCode() {
        // given
        int categoryCode = 4;
        // when
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);
        // then
        assertThat(list)
            .isNotNull()
            .isNotEmpty()
            .allSatisfy((menu) -> {
                assertThat(menu.getMenuCode()).isNotZero().isPositive();
                assertThat(menu.getMenuName()).isNotNull();
                assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                assertThat(menu.getCategoryCode()).isEqualTo(categoryCode);
                assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                        (status) -> "Y".equals(status),
                        (status) -> "N".equals(status)
                );
            });
    }

    @DisplayName("존재하지 않는 카테고리 코드 조회시 빈 리스트가 반환된다.")
    @Test
    void findByCategoryCode2() {
        // given
        int categoryCode = 444444444;
        // when
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);
        // then
        assertThat(list)
                .isNotNull()
                .isEmpty();
    }
}