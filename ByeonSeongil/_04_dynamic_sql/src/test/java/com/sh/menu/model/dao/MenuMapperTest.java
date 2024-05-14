package com.sh.menu.model.dao;

import com.sh.common.SearchCriteria;
import com.sh.menu.model.dao.MenuMapper;
import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static com.sh.menu.view.MainView.todayRecommendation;
import static org.assertj.core.api.Assertions.assertThat;


class MenuMapperTest {
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

    @ParameterizedTest
    @DisplayName("동적SQL(if) - 메뉴이름 일부로 검색이 가능하다.")
    @ValueSource(strings = {"라떼", "쥬스"})
    void test1(String value) {
//         given
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName("name");
        searchCriteria.setValue(value);
        // when
        List<MenuDto> menuList = menuMapper.searchMenu(searchCriteria);
        System.out.println(menuList);
        // then
        assertThat(menuList)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu.getMenuName().contains(String.valueOf(searchCriteria.getValue())));
    }

    @ParameterizedTest
    @DisplayName("동적SQL(if) - 카테고리번호로 검색이 가능하다.")
    @ValueSource(ints = {4, 8, 11})
        // 한식, 커피, 동양
    void test2(int value) {
        // given
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName("category");
        searchCriteria.setValue(value);
        // when
        List<MenuDto> menuList = menuMapper.searchMenu(searchCriteria);
        System.out.println(menuList);
        // then
        assertThat(menuList)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu.getCategoryCode() == value);
    }

    @DisplayName("동적SQL(if) - 가격범위로 검색이 가능하다.")
    @ParameterizedTest
    @CsvSource(value = {"10000,20000","20000,30000","0,30000"})
    void test3(int start, int end) {
        // given
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName("price");
        searchCriteria.setStart(start);
        searchCriteria.setEnd(end);
        // when
        List<MenuDto> menuList = menuMapper.searchMenu(searchCriteria);
        System.out.println(menuList);
        // then
        assertThat(menuList)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu.getMenuPrice() >= (int) searchCriteria.getStart()
                        && menu.getMenuPrice() <= (int) searchCriteria.getEnd());
    }

    @DisplayName("동적SQL(choose) - 카테고리명으로 분기 검색할 수 있다.")
    @ParameterizedTest
    @MethodSource("supplyCategories") // 동일한 이름의 static 메서드로부터 소스처리
    void test4(String value, List<Integer> categoryCodes) {
        // given
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setValue(value);
        // when
        List<MenuDto> menuList = menuMapper.searchMenu2(searchCriteria);
        System.out.println(menuList);
        // then
        assertThat(menuList).isNotNull().isNotEmpty()
                .allMatch((menu) -> categoryCodes.contains(menu.getCategoryCode()));

    }

    private static Stream<Arguments> supplyCategories() {
        return Stream.of(
                Arguments.of("식사", List.of(4, 5, 6, 7)),
                Arguments.of("음료", List.of(8, 9, 10)),
                Arguments.of("디저트", List.of(11, 12))
        );
    }

    @DisplayName("동적SQL(foreach) - 여러개의 메뉴코드를 in연산자로 처리할 수 있다.")
    @Test
    void test5() {
        // given
        // when
        List<MenuDto> menuList = menuMapper.searchMenu3();
        System.out.println(menuList);
        // then
        assertThat(menuList)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> todayRecommendation().contains(menu.getMenuCode()));
    }

    @DisplayName("동적SQL(where | trim) - where절을 동적으로 오류없이 작성할 수 있다.")
    @Test
    void test6() {
        // given
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setName("category");
        searchCriteria.setValue(4);
        // when
        List<MenuDto> menuList = menuMapper.searchMenu4(searchCriteria);
        System.out.println(menuList);
        // then
        assertThat(menuList).isNotNull().isNotEmpty();
    }


}