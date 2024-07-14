package com.sh.app._02.menu.repository;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import com.sh.app.menu.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.STREAM;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 우리가 작성한 MenuRepository 인터페이스의 상속구조
 * - jpa는 MenuRepository 인터페이스의 구현객체를 동적으로 생성해서 제공한다
 * - MenuRepository의 추상메소드를 구현했을 것이다.
 * - 이 객체는 부모인터페이스인 jpaRepository의 추상메소드를 구현했을 것이다.
 * - 이 객체는 부모의부모 인터페이스인 PagingAndSortCrudRepository, CrudRepository, Repository의 추상메소드를 구현했을 것이다.
 */

@DataJpaTest // jpa관련 bean만 로드해서 @SpringBootTest대비 가볍다는 장점이 있다
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        // 테스트용 메모리 DB안쓰고, 실제 DB 사용하겠다
class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;


    @Test
    @DisplayName("")
    void test1() {
        assertThat(menuRepository).isNotNull();
        List<Menu> all = menuRepository.findAll();
        all.forEach(System.out::println);

    }

    @Test
    @DisplayName("Repository 인터페이스 제공 메소드")
    void test2() {
        // nullable한 객체를 감싼 객체, 값이 있을 때, 없을 때에 대한 분기처리 제공
        Optional<Menu> optMenu = menuRepository.findById(3000L);
        optMenu.orElse(null); // optMenu안에 값이 존재하면 반환하고, 없으면 기본값 반환
        // Optional API는 값이 없을 떄 다양한 메소드를 제공한다
        optMenu.orElseThrow(); // 없으면 error을 던져라


        System.out.println("optMenu = " + optMenu);
    }

    @Test
    @DisplayName("Repository 인터페이스 제공 메소드")
    void test3FindAll() {
        List<Menu> menus=menuRepository.findAll();
        menus.forEach(System.out::println);
    }

    @Test
    @DisplayName("Repository 인터페이스 제공 메소드 insert")
    void test4InsertMenu() {
        Menu menu=Menu.builder()
                .menuName("우유맛소고기덮밥")
                .menuPrice(30000)
                .categoryCode(4L)
                .orderableStatus(OrderableStatus.Y)
                .build();
        //지금 rollback false가 없기 떄문에 실제로 DB에는 안들어 갔다
        Menu saveMenu = menuRepository.save(menu);

        System.out.println("saveMenu = " + saveMenu);

    }
    @Rollback(value = false)
    @Test
    @DisplayName("Repository 인터페이스 제공 메소드 update")
    void test5Update() {
        Long menuCode=10L;
        Optional<Menu> optMenu = menuRepository.findById(menuCode);
//        Menu menu = optMenu.get(); // 값이 안에 없으면 에러가 던져진다
        Menu menu = optMenu.orElse(null); // 그러니깐 이렇게 써라
        String menuName="수박"+menu.getMenuName();
        menu.changeMenuName(menuName);

        // 쿼리 코드가 안보이는 건 @Rollback(value = false) 없어서 그렇고, DB에도 안들어간다
        Optional<Menu> changedMenu = menuRepository.findById(menuCode);
        System.out.println("changedMenu = " + changedMenu);
    }

    /**
     * 삭제 메소드
     * 1. delete(T)
     * 2. deleteById(ID)
     */
    @Test
    @DisplayName("Repository 인터페이스 제공 메소드 Delete")
    @Rollback(value = false) // 이놈때문에 메소드가 다 끝나면 실제 쿼리가 날라간다 = DB를 건드린다
    void test5Delete() {
        long menuCode = 10L;
        menuRepository.deleteById(menuCode); //
        Optional<Menu> optMenu = menuRepository.findById(menuCode);
        System.out.println("optMenu = " + optMenu);

        // 이걸 한 번 더 실행하면 이미 없는 놈이라서 delete문을 왜 날려??
    }

}