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
    //위에 속성들을 Fixture라고 한다, 테스트를 위한 속성

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = new MenuDto();
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.close();
    }

    /**
     * <pre>
     * 요구사항대로 테스트를 작성해야 한다.
     * given-when-then패턴을 적용해서 작성한다
     * 준비   실행   검증 단계로 테스트를 작성
     * </pre>
     */

    @DisplayName("메뉴 전체 조회")
    @Test
    void findAll() {
        //given
        //when
        List<MenuDto> menuDtos = menuMapper.findAll();
        System.out.println(menuDtos);
        //then
        assertThat(menuDtos)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) ->
                        menu != null
                )
                .allSatisfy((menu) -> {
                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    //assertThat(menu.getCategoryCode()) 이놈은 null값인게 있어서 넘어간다
                    assertThat(menu.getCategoryCode()).satisfiesAnyOf(
                            (status) -> "Y".equals(status),
                            (status) -> "N".equals(status)
                    );
                });


    }

    @DisplayName("메뉴 코드로 조회")
    @Test
    void findByMenuCode() {
        int menuCode = 1;
        MenuDto menuDto = menuMapper.findByMenuCode(menuCode);
        assertThat(menuDto)
                .isNotNull();
        assertThat(menuDto.getMenuCode()).isNotZero().isPositive();
        assertThat(menuDto.getMenuName()).isNotNull();
        assertThat(menuDto.getMenuPrice()).isNotZero().isPositive();
        assertThat(menuDto.getCategoryCode()).satisfiesAnyOf(
                (status) -> "Y".equals(status),
                (status) -> "N".equals(status)
        );
        assertThat(menuDto).satisfies(
                (_menu) -> assertThat(_menu.getMenuCode()).isEqualTo(menuCode),
                (_menu) -> assertThat(_menu.getMenuName()).isNotNull(),
                (_menu) -> assertThat(_menu.getMenuPrice()).isNotZero().isPositive(),
                (_menu) -> assertThat(_menu.getOrderableStatus()).satisfiesAnyOf(
                        (status) -> "Y".equals(status),
                        (status) -> "N".equals(status)
                )
        );

    }

    @DisplayName("존재하지 않는 메뉴코드로 조회한 경우 null이 반환되어야 한다")
    @Test
    void findByMenuCode2() {
        //given
        int menuCode = 1;
        //when
        MenuDto menuDto = menuMapper.findByMenuCode(menuCode);
        //then
        assertThat(menuDto).satisfies(
                (_menu) -> assertThat(_menu.getMenuCode()).isEqualTo(menuCode),
                (_menu) -> assertThat(_menu.getMenuName()).isNotNull(),
                (_menu) -> assertThat(_menu.getMenuPrice()).isNotZero().isPositive(),
                (_menu) -> assertThat(_menu.getOrderableStatus()).satisfiesAnyOf(
                        (status) -> "Y".equals(status),
                        (status) -> "N".equals(status)
                )
        );
        System.out.println(menuDto);

    }

    @DisplayName("주어진 카테고리 코드의 메뉴만 조회할 수 있다")
    @Test
    void findByCetegoryCode() {
        //given
        int category_code = 10;
        //when
        List<MenuDto> menuDtos = menuMapper.findByCategoryCode(category_code);
        assertThat(menuDtos)
                .isNotNull()
                .allSatisfy((mane) -> {
                    assertThat(mane.getMenuCode()).isNotZero().isPositive();
                    assertThat(mane.getMenuName()).isNotNull();
                    assertThat(mane.getMenuPrice()).isNotZero().isPositive();
                    assertThat(mane.getCategoryCode()).satisfiesAnyOf(
                            (status) -> "Y".equals(status),
                            (status) -> "N".equals(status)
                    );
                });

    }

    @DisplayName("주어진 카테고리 코드의 메뉴만 조회할 수 있다")
    @Test
    void findByCategoryCode2() {
        //given
        int category_code = 444444444;
        //when
        List<MenuDto> menuDtos = menuMapper.findByCategoryCode(category_code);
        assertThat(menuDtos)
                .isNotNull()
                .allSatisfy((mane) -> {
                    assertThat(mane.getMenuCode()).isNotZero().isPositive();
                    assertThat(mane.getMenuName()).isNotNull();
                    assertThat(mane.getMenuPrice()).isNotZero().isPositive();
                    assertThat(mane.getCategoryCode()).satisfiesAnyOf(
                            (status) -> "Y".equals(status),
                            (status) -> "N".equals(status)
                    );
                });

    }
}