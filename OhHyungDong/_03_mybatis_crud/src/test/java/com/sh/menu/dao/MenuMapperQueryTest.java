package com.sh.menu.dao;

import com.sh.menu.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

class MenuMapperQueryTest {
    //Fixture : 테스트 할 때 필요한 대상(MenuMapper) + 테스트 할 때 도움이되는 대상(SqlSession)
    SqlSession sqlSession;
    MenuMapper menuMapper;

    @BeforeEach
    void setUp() {
        /**
         * 공통적으로 들어가는 코드 객체 생성할 때마다 동작하도록 BeforeEach에 설정
         */
        sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.close();
    }

    /**
     * Test Code 작성 Tip
     * - 요구사항대로 테스트를 작성해야 한다.
     * - given - when - then 패턴으로 작성
     * 준비 - 실행 - 검증 단계로 테스트 작성
     */
    @DisplayName("메뉴 전체 조회")
    @Test
    void findAll() {
        //given
        // when
        List<MenuDto> list = menuMapper.findAll();
        //then
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu != null)
                .allSatisfy((menu) -> {
                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    //categoryCode 생략 -> nullable한 컬럼은 검증 제외
                    assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                            (status) -> "Y".equals(status),
                            (status) -> "N".equals(status)
                    );

                });

    }

    @DisplayName("메뉴 코드로 한건의 메뉴를 조회할 수 있따.")
    @Test
    void findByMenuCode() {
        //given
        int menuCode = 1; //존재하는 메뉴코드
        //when
        MenuDto menu = menuMapper.findByMenuCode(menuCode);
        //then
        assertThat(menu).isNotNull();
        assertThat(menu.getMenuCode()).isEqualTo(menuCode);
        assertThat(menu.getMenuName()).isNotNull();
        assertThat(menu.getMenuPrice()).isNotZero().isPositive();
        assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                (status) -> "Y".equals(status),
                (status) -> "N".equals(status));

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

    @DisplayName("존재하지 않는 메뉴코드로 조회 한 경우 null이 반환되어야 한다.")
    @Test
    void findByMenuCode2() {
        //given
        int menuCode = 12345;
        //when
        MenuDto menuCode1 = menuMapper.findByMenuCode(menuCode);
        //then
        assertThat(menuCode1).isNull();
    }

    @DisplayName("주어진 카테코리 코드의 메뉴만 조회할 수 있다.")
    @Test
    void findByCategoryCode() {
        //given
        int categoryCode = 4;
        //when
        List<MenuDto> lists = (List<MenuDto>) menuMapper.findByCategoryCode(categoryCode);
        //then
        assertThat(lists)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu != null)
                .allSatisfy((menu) -> {
                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    assertThat(menu.getCategoryCode()).isEqualTo(categoryCode);
                    //categoryCode 생략 -> nullable한 컬럼은 검증 제외
                    assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                            (status) -> "Y".equals(status),
                            (status) -> "N".equals(status)
                    );

                });

    }

    @Test
    @DisplayName("존재하지 않는 카테고리 코드 조회시 빈 리스트가 반환된다.")
    void findByCategoryCode2() {

        //given
        int categoryCode = 444;
        //when
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);
        //tehn
        assertThat(list).isNotNull().isEmpty();

    }
}
