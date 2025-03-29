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


    // 텍스트 할 때 도움 되는 대상
    SqlSession sqlSession;
    MenuMapper menuMapper;


    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.menuMapper = sqlSession.getMapper(MenuMapper.class);

    }

    @AfterEach
    void tearDown() {
        this.sqlSession.commit(); // 생략해도 Connection, 즉 여기서는 SqlSession 해제시 자동 커밋 된다. ( 테스트 환경 제외)
        this.sqlSession.close();

    }


    /**
     * <pre>
     *
     * 요구사항대로 테스트를 작성해야 한다.
     * given-when-then패턴을 적용해서 작성한다.
     * 준비- 실행-검증 단계로 테스트를 작성한다.
     *
     *
     * </pre>
     *
     *
     */

    @Test
    void findAll() {
        //given
        //when
        List<MenuDto> list = menuMapper.findAll();
        //then
        assertThat(list)
                .isNotNull()
                .isNotEmpty()
                .allMatch(menu -> menu != null) // 요소체크
                .allSatisfy((menu) -> {
                    assertThat(menu.getMenuCode()).isNotZero().isPositive();
                    assertThat(menu.getMenuName()).isNotNull();
                    assertThat(menu.getMenuPrice()).isNotZero().isPositive();
                    assertThat(menu.getOrderableStatus()).satisfiesAnyOf(
                            (status) -> "Y".equals(status),
                            (status) -> "N".equals(status)
                            );
                });

    }

    @DisplayName("메뉴코드로 한건의 메뉴를 조회할 수 있다.")
    @Test
    void findByMenuCode() {
        //given -> 매개변수 있을 때 사용
        int menuCode = 1; // 존재하는 메뉴코드
        //when
        MenuDto menu = menuMapper.findByMenuCode(menuCode);
        //then
        assertThat(menu).isNotNull(); // 존재하는 메뉴라서 널이면 안됨
        assertThat(menu.getMenuCode()).isNotZero().isPositive();
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

    // 주어진 요구사항에 다양한 테스트코드를 미리미리 생각하자.
    // 테스트 코드까지 만들면 시간은 오래걸리지만 유지보수하기 좋다.

    @DisplayName("존재하지 않는 메뉴코드로 조회한 경우 null이 반환되어야 한다.")
    @Test
    void findByMenuCode2() {
        //given
        int menuCode = 123456789;
        //when
        MenuDto menu = menuMapper.findByMenuCode(menuCode);
        //then
        assertThat(menu).isNull();
    }
    @DisplayName("주어진 카테고리 코드의 메뉴만 조회할 수 있다.")
    @Test
    void findByCategoryCode() {
        //given
        int categoryCode = 10;
        //when
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);

        //then
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

    @DisplayName("존재하지 않는 카테고리 코드 조회시 빈 리스트만 반환된다.")
    @Test
    void findByCategoryCode2() {
        //given
        int categoryCode = 4444;
        //when
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);

        //then

        assertThat(list)
                .isNotNull()
                .isEmpty();
    }

}