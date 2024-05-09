package com.sh.menu.model.dao;

import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

class MenuMapperQueryTest {
    //1. 실제 쿼리테스트를 수행 전에 세션이 필요하므로 세션 Fixture 부터 생성
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

    @DisplayName("메뉴 전체를 조회한다.")
    @Test
    void findAll() {
        //given
        //when
        List<MenuDto> list = menuMapper.findAll();
        //then
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu)->menu != null)
                .allSatisfy((menu)->{
                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    // nullable한 컬럼은 검증제외
                    assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                            (status) -> "Y".equals(status),
                            (status) -> "N".equals(status)
                    );
                });
    }

    @DisplayName("메뉴코드로 한건의 메뉴를 조회할 수 있다")
    @Test
    void findByMenuCode() {
        //given
        int menuCode = 1;
        //when
        MenuDto menu = menuMapper.findByMenuCode(menuCode);
        //then
        assertThat(menu).isNotNull();
        assertThat(menu.getMenuCode()).isEqualTo(menuCode);
        assertThat(menu.getMenuName()).isNotNull();
        assertThat(menu.getMenuPrice()).isNotZero().isPositive();
        assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                (status) -> "Y".equals(status),
                (status) -> "N".equals(status)
        );

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
    @DisplayName("존재하지 않는 메뉴코드로 조회한 경우 null이 반환되어야 한다")
    @Test
    void findByMenuCode2(){
        //given
        int menucode = 1231423123;
        //when
        MenuDto menu = menuMapper.findByMenuCode(menucode);
        //then
        assertThat(menu).isNull();
    }

    @DisplayName("주어진 카테고리 코드의 메뉴만 조회할수 있다.")
    @Test
    void findByCategoryCode(){
        //given
        int categoryCode = 4;
        //when
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);
        //then
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu)-> menu != null)
                .allSatisfy((menu)->{
                   assertThat(menu.getMenuCode()).isNotZero().isPositive();
                   assertThat(menu.getMenuName()).isNotNull();
                   assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                   assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                           (status) -> "Y".equals(status),
                           (status) -> "N".equals(status)
                   );
                });

    }

    @DisplayName("주어진 카테고리 코드로 메뉴를 조회한 경우 빈 리스트를 반환한다")
    @Test
    void findByCategoryCode2() {
        //given
        int categoryCode = 300;
        //when
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);
        //then
        assertThat(list).isEmpty();
    }
}