package com.sh.app._03.query.method;

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
import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

/**
 * <pre>
 *    Query Method
 *  - jpql을 메소드 명으로 생성하는 spring-data-jpa의 편의 기능
 *  - find [엔티티명] By 컬럼명 [연산자] 와 같이 작성한다.
 *  - 예시) findMenuByMenuCode(Long), findAllByMenuNameLike(String), findByMenuNameAndOrderableStatus(String, OrderableStatus) -> 🙉이게 메소드이름
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
//        menuRepository.findByMenuNameLike(menuName); 이렇게 쓰면 % 안쓴거나 마찬가지
        /**
         * Hibernate:
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         *     where
         *         m1_0.menu_name like ? escape '\\'
         */
        menus.forEach(System.out::println);

        // then
        assertThat(menus).allMatch((menu) -> menu.getMenuName().contains(menuName));

    }

    @Test
    @DisplayName("숫자 범위 연산 처리") // 10000원 이상인 메뉴만 뽑기!
    void test2() {
        // given
        int minMenuPrice = 10000;
        int maxMenuPrice = 20000;

        // when
        List<Menu> menus = menuRepository.findByMenuPriceGreaterThanEqual(minMenuPrice);
        List<Menu> menus2 = menuRepository.findByMenuPriceLessThanEqual(maxMenuPrice);
        List<Menu> menus3 = menuRepository.findByMenuPriceBetween(minMenuPrice, maxMenuPrice);
        /**
         * Hibernate: 🙉10000원 이상인 메뉴
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         *     where
         *         m1_0.menu_price>=?
         *
         * Hibernate: 🙉20000원 이하인 메뉴
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         *     where
         *         m1_0.menu_price<=?
         *  Hibernate: 🙉10000원과 20000원 사이의 메뉴
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         *     where
         *         m1_0.menu_price between ? and ?
         */
        menus.forEach(System.out::println);

        // then
        assertThat(menus).allMatch((menu) -> menu.getMenuPrice() >= minMenuPrice);
        assertThat(menus2).allMatch((menu) -> menu.getMenuPrice() <= maxMenuPrice);
        assertThat(menus3).allMatch((menu) ->
                menu.getMenuPrice() >= minMenuPrice && menu.getMenuPrice() <= maxMenuPrice);
    }

    /**
     * 정렬 하는 방법
     * 1. Sort 객체
     * 2. Query Method - OrderBy 구문 작성
     */
    @Test
    @DisplayName("정렬")
    void test3() {
        // given
        // when
        // OrderBy앞에 필드명을 작성하지 않은 경우도 By는 써줘야함
//        List<Menu> menus = menuRepository.findAllByOrderByMenuNameAsc(); //findAllBy에서 By를 꼭 써줘야 함
        List<Menu> menus = menuRepository.findAllByOrderByMenuNameDesc(); //findAllBy에서 By를 꼭 써줘야 함
        /**
         * Hibernate: 🙉ㄱ부터 정렬해서 보여줌
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         *     order by
         *         m1_0.menu_name
         *  Hibernate: 🙉ㅎ 부터 내림차순으로 보여줌
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         *     order by
         *         m1_0.menu_name desc
         */
        menus.forEach(System.out::println);
        // then
        // Comparator 비교 기준 람다를 전달
//        assertThat(menus).isSortedAccordingTo((m1, m2) -> m1.getMenuName().compareTo(m2.getMenuName())); // m1메뉴네임이랑 m2 메뉴 네임 똑같니?
        assertThat(menus).isSortedAccordingTo((m1, m2) -> m2.getMenuName().compareTo(m1.getMenuName())); // m1메뉴네임이랑 m2 메뉴 네임 똑같니?
    }

    /**
     * first, top 키워드를 이용해서 TopN분석 조회 가능
     */
    @Test
    @DisplayName("TopN분석")
    void test4() {
        // given
        // when
        List<Menu> menus = menuRepository.findFirst5ByOrderByMenuPriceDesc();
        /**
         * Hibernate:
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         *     order by
         *         m1_0.menu_price desc
         *     limit
         *         ?
         */
        menus.forEach(System.out::println);
        // then
        assertThat(menus)
                .isSortedAccordingTo((m1, m2) -> m2.getMenuPrice() - m1.getMenuPrice())
                .size().isLessThanOrEqualTo(5); // 5개가 안되면 3개가 나올 수도 있음
    }

    /**
     * Spring - Data - JPA의 페이징 처리
     * - jpa에서 페이징은 spring으로 넘어오면서 새로운 객체들이 있움
     * - Pageable 객체(page, size)를 전달하고, Page<T> 타입을 반환받는다.
     * - Page<T> 컨텐츠, 총 페이지수, 총 개수, 첫번째 혹은 마지막 페이지 여부 등
     */
    @ParameterizedTest
    @DisplayName("페이징 처리")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6}) // 🙉1부터 쓰면 안됨!
    void test5(int pageNumber) {
        // given
//        int pageNumber = 0; // 현재 페이지 (✨0부터 시작) -> 위에다가 선언해벌임
        int pageSize = 10; // 한 페이지 당 노출한 컨텐츠 수
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        // when
//        Page<Menu> menuPage = menuRepository.findAll(pageable); // 이미 제공
        Page<Menu> menuPage = menuRepository.findByOrderableStatus(OrderableStatus.Y, pageable); // Y인 애들만 옴!

        System.out.println(menuPage);
        /**
         * Hibernate:
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         *     where
         *         m1_0.orderable_status=?
         *     limit
         *         ?, ?
         * Hibernate:
         *     select
         *         count(m1_0.menu_code)
         *     from
         *         tbl_menu m1_0
         *     where
         *         m1_0.orderable_status=?
         */
        System.out.println(menuPage);
        System.out.println("조회한 내용 목록 : " + menuPage.getContent());
        System.out.println("총 페이지 수 : " + menuPage.getTotalPages());
        System.out.println("총 메뉴 수 : " + menuPage.getTotalElements());
        System.out.println("해당 페이지에 표시 될 요소 수 : " + menuPage.getSize());
        System.out.println("해당 페이지에 실제 요소 수 : " + menuPage.getNumberOfElements());
        System.out.println("첫 페이지 여부 : " + menuPage.isFirst());
        System.out.println("마지막 페이지 여부 : " + menuPage.isLast());
        System.out.println("정렬 방식 : " + menuPage.getSort());
        System.out.println("여러 페이지 중 현재 인덱스(인덱스) : " + menuPage.getNumber());

        //Page<T> 객체는 Iterable구현체로써 바로 반복처리가 가능하다.
        menuPage.forEach(System.out::println);

        // then
        assertThat(menuPage.getNumberOfElements()).isEqualTo(menuPage.getContent().size());
    }

    @Test
    @DisplayName("IN 연산자")
    void test6() {
        // given
        List<Long> categoryCodes = List.of(4L, 5L, 6L);
        // when
        List<Menu> menus = menuRepository.findByCategoryCodeIn(categoryCodes); // 4, 5, 6 에 포함된 거 출력
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .allMatch((menu) -> categoryCodes.contains(menu.getCategoryCode()));
    }
}
