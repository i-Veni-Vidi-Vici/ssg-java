package com.sh.app.query.method;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import com.sh.app.menu.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * Query Method
 * - jpql을 메소드명으로 생성하는 spring-data-jpa의 편의기능
 * - find [엔티티명] By 컬럼명 [연산자] 와 같이 작성한다.
 * - 예시) findMenuByMenuCode(Long), findAllByMenuNameLike(String), findByMenuNameAndOrderableStatus(String, OrderableStatus)
 *
 * </pre>
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MenuQueryMethodTest {
    @Autowired
    private MenuRepository menuRepository;

    @Test
    @DisplayName("LIKE 연산 처리")
    void test1() {
        // given
        String menuName = "밥";
        // when
//        List<Menu> menus = menuRepository.findByMenuNameLike("%" + menuName + "%");
        List<Menu> menus = menuRepository.findByMenuNameContaining(menuName);
        menus.forEach(System.out::println);
        // then
        assertThat(menus).allMatch((menu) -> menu.getMenuName().contains(menuName));
    }


    @Test
    @DisplayName("숫자범위 연산처리")
    void test2() {
        //given
        int minMenuPrice = 10000;
        int maxMenuPrice = 20000;
        //when
        List<Menu> menus = menuRepository.findByMenuPriceGreaterThanEqual(minMenuPrice);
        List<Menu> menus2 = menuRepository.findByMenuPriceLessThanEqual(maxMenuPrice);
        List<Menu> menus3 = menuRepository.findByMenuPriceBetween(minMenuPrice, maxMenuPrice);
        menus.forEach(System.out::println);
        //then
        assertThat(menus).allMatch((menu) -> menu.getMenuPrice() >= minMenuPrice);
        assertThat(menus2).allMatch((menu) -> menu.getMenuPrice() <= maxMenuPrice);
        assertThat(menus3).allMatch((menu) ->
                menu.getMenuPrice() >= minMenuPrice && menu.getMenuPrice() <= maxMenuPrice);


    }

    @Test
    @DisplayName("정렬")
    void test3() {
        //given
        //when
        //OrderBy앞에 필드명을 작성하지 않은 경우도 By는 써주어야한다.
    List<Menu> menus = menuRepository.findAllByOrderByMenuNameAsc();
    menus.forEach(System.out::println);
    //then
        //Comparator 비교 기준 람다를 전달
    assertThat(menus).isSortedAccordingTo((m1,m2) -> m1.getMenuName().compareTo(m2.getMenuName()));
    assertThat(menus).isSortedAccordingTo((m1,m2) -> m2.getMenuName().compareTo(m1.getMenuName())); // 둘이 바꾸면 역순으로 체크

    }


    /**
     * first , top 키워드를 이용해서 TopN 분석 조회 가능
     *
     */

    @Test
    @DisplayName("TopN 분석")
    void test4() {
        //given
        //when
        List<Menu> menus = menuRepository.findFirst5ByOrderByMenuPriceDesc();
        menus.forEach(System.out::println);
        //then
        assertThat(menus).isSortedAccordingTo((m1,m2) -> m1.getMenuPrice() - m1.getMenuPrice())
                .size().isLessThanOrEqualTo(5);
    }


    /**
     * Spring-Data-JPA의 페이징처리
     * - Pageable객체(page,size)를 전달하고, Page<T>타입을 반환받는다.
     * - Page<T> 컨텐츠, 총페이지수, 총개수, 첫번째/마지막 페이지 여부
     *
     *
     */

    @ParameterizedTest
    @DisplayName("페이징처리")
    @ValueSource(ints = {0,1,2,3,4,5})
    void test5() {
        //given
        int pageNumber = 0; // 현재 페이지 (0부터 시작)
        int pageSize = 10; // 한 페이지당 노출할 컨텐츠 수
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        //when
//        Page<Menu> menuPage = menuRepository.findAll(pageable); // 이미제공
        Page<Menu> menuPage = menuRepository.findByOrderableStatus(OrderableStatus.Y,pageable); // 이미제공
        System.out.println(menuPage);
        //then
        System.out.println("조회한 내용 목록 : " + menuPage.getContent());
        System.out.println("총 페이지 수 : " + menuPage.getTotalPages()); //4
        System.out.println("총 메뉴 수 : " + menuPage.getTotalElements()); //35
        System.out.println("해당 페이지에 표시 될 요소 수 : " + menuPage.getSize()); // 10
        System.out.println("해당 페이지에 실제 요소 수 : " + menuPage.getNumberOfElements()); //10
        System.out.println("첫 페이지 여부 : " + menuPage.isFirst());
        System.out.println("마지막 페이지 여부 : " + menuPage.isLast());
        System.out.println("정렬 방식 : " + menuPage.getSort());
        System.out.println("여러 페이지 중 현재 페이지(인덱스) : " + menuPage.getNumber());

        // Page<T>객체는 Iterable구현체로써 바로 반복처리가 가능하다.
        menuPage.forEach(System.out::println);
        // then

    }

    @Test
    @DisplayName("IN 연산자")
    void test6() {
        //given
        List<Long> categoryCodes = List.of(4L,5L,6L);
        //when
        List<Menu> menus = menuRepository.findByCategoryCodeIn(categoryCodes);
        menus.forEach(System.out::println);
        //then
        assertThat(menus).isNotNull()
                .allMatch((menu) -> categoryCodes.contains(menu.getCategoryCode()));
    }



}
