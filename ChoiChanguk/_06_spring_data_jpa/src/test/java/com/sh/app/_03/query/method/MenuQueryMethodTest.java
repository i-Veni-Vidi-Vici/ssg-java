package com.sh.app._03.query.method;


import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import com.sh.app.menu.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
 * - jpql을 메소드명으로 생성하는 spring-data-jpa의 편의 기능
 * - find 엔티티명 by 컬럼명 [연산자] 와 같이 작성한다
 * - 예시) findMenuByMenuCode(menuCode),
 *        findAllByMenuNameLike(menuName),
 *        findByMenuNameAndOrderableStatus(String(menuName),
 *        OrderableStatus
 * </pre>
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE )
public class MenuQueryMethodTest {

    @Autowired
    private MenuRepository menuRepository;


    @Test
    @DisplayName("LIKE 연산 처리")
    void test1Like() {
        String menuName = "밥";
        // 메소드를 자동으로 만들어주지는 않는다
        List<Menu> menus = menuRepository.findByMenuNameLike("%"+menuName+"%");
        List<Menu> menusContaining = menuRepository.findByMenuNameContaining(menuName); // % 안써줘도 됨
//        menus.forEach(System.out::println);
        menusContaining.forEach(System.out::println);
    }

    @Test
    @DisplayName("숫자범위 연산처리")
    void testNumber() {
        int minMenuPrice=10000;
        int maxMenuPrice=12000;
        List<Menu>greaterThan=menuRepository.findByMenuPriceGreaterThanEqual(minMenuPrice);
        List<Menu>lessThan=menuRepository.findByMenuPriceLessThanEqual(maxMenuPrice);
        List<Menu>between=menuRepository.findByMenuPriceBetween(minMenuPrice,maxMenuPrice);
//        GreaterThan.forEach(System.out::println);
//        LessThan.forEach(System.out::println);

        between.forEach(System.out::println);
    }

    /**
     * 정렬하는 방법
     * 1. Sort객체
     * 2. Query Method OrderBy구문 작성
     */
    @Test
    @DisplayName("정렬")
    void testSort() {
        String menuName="";
        //tip OrderBy앞에 필드명을 작성하지 않는 경우도 by는 써주어야 한다
        List<Menu> ascMenus=menuRepository.findAllByOrderByMenuNameAsc();
        List<Menu> descMenus=menuRepository.findAllByOrderByMenuNameDesc();
        assertThat(ascMenus).isSortedAccordingTo((menu1,menu2)->
            menu1.getMenuName().compareTo(menu2.getMenuName())
        );
        // Comparator 비교 기준 람다를 전달
//        ascMenus.forEach(System.out::println);
        descMenus.forEach(System.out::println);

    }

    /**
     * first, top 키워드를 이용해서 TopN 분석 조회 가능
     */
    @Test
    @DisplayName("TopN 분석")
    void testTopN() {
        List<Menu> first5= menuRepository.findFirst5ByOrderByMenuPriceDesc();


        first5.forEach(System.out::println);

    }

    /**
     * Spring - data - jpa의 페이징처리
     * - Pageable객체(page,size)를 전달하고, Page<T>타입을 반환받는다
     * - Page<T> 컨텐츠, 총페이지 수, 총개수, 첫번째 or 마지막 페이지 여부
     */
    @Test
    @DisplayName("페이징처리")
    void testPaging() {
        int pageNumber=0; // 현재페이지
        int pageSize=10; //한 페이지당 출력 할 개수
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Menu> menuPage = menuRepository.findAll(pageable);
        Page<Menu> menus2 = menuRepository.findByOrderableStatus(OrderableStatus.Y,pageable);
        menus2.forEach(System.out::println);


        System.out.println("조회한 내용 목록 : " + menuPage.getContent());                   // [Menu(menuCode=3, menuName=생갈치쉐이크, menuPrice=6000, categoryCode=10, orderableStatus=Y), Menu(menuCode=4, menuName=갈릭미역파르페, menuPrice=7000, categoryCode=10, orderableStatus=Y), Menu(menuCode=6, menuName=생마늘샐러드, menuPrice=12000, categoryCode=4, orderableStatus=Y), Menu(menuCode=7, menuName=민트미역국, menuPrice=15000, categoryCode=4, orderableStatus=Y), Menu(menuCode=8, menuName=한우딸기국밥, menuPrice=20000, categoryCode=4, orderableStatus=Y), Menu(menuCode=9, menuName=홍어마카롱, menuPrice=9000, categoryCode=12, orderableStatus=Y), Menu(menuCode=11, menuName=정어리빙수, menuPrice=10000, categoryCode=10, orderableStatus=Y), Menu(menuCode=12, menuName=날치알스크류바, menuPrice=2000, categoryCode=10, orderableStatus=Y), Menu(menuCode=13, menuName=직화구이젤라또, menuPrice=8000, categoryCode=12, orderableStatus=Y), Menu(menuCode=14, menuName=과메기커틀릿, menuPrice=13000, categoryCode=6, orderableStatus=Y)]
        System.out.println("총 페이지 수 : " + menuPage.getTotalPages());                   // 7
        System.out.println("총 메뉴 수 : " + menuPage.getTotalElements());                  // 64
        System.out.println("해당 페이지에 표시 될 요소 수 : " + menuPage.getSize());           // 10
        System.out.println("해당 페이지에 실제 요소 수 : " + menuPage.getNumberOfElements());  // 10
        System.out.println("첫 페이지 여부 : " + menuPage.isFirst());                        // true
        System.out.println("마지막 페이지 여부 : " + menuPage.isLast());                      // false
        System.out.println("정렬 방식 : " + menuPage.getSort());                             // UNSORTED
        System.out.println("여러 페이지 중 현재 페이지(인덱스) : " + menuPage.getNumber());     // 0


    }

    @Test
    @DisplayName("IN 연산자")
    void testIN() {
        List<Long> categoryCodes=List.of(4L,5L,6L);

        List<Menu> menus=menuRepository.findByCategoryCodeIn(categoryCodes);
        menus.forEach(System.out::println);
    }
}
