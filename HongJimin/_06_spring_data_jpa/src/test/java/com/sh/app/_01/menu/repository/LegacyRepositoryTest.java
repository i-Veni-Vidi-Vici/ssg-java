package com.sh.app._01.menu.repository;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.repository.MenuRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * Spring환경에서는 EntityManagerFactory, EntityManager객체의 생명주기가 모두 Spring ApplicationContext하위에서 관리된다.
 * 서비스단에서 처리해야할 트랜잭션 범위설정, commit/rollback처리 모두 AOP를 이용해 별도로 분리되어 처리된다.
 *      - 오류가 안나면 commit, 나면 rollback처리를 함
 * </pre>
 */
@SpringBootTest
class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;


    @Test
    @DisplayName("메뉴 한건 조회")
    void test1() {
        // given
        Long menuCode = 10L;
        // when
        Menu menu = menuRepository.findByMenuCode(menuCode);
        /*
            Hibernate:
                select
                    m1_0.menu_code,
                    m1_0.category_code,
                    m1_0.menu_name,
                    m1_0.menu_price,
                    m1_0.orderable_status
                from
                    tbl_menu m1_0
                where
                    m1_0.menu_code=?
         */
        System.out.println(menu);
        // then
        assertThat(menu).isNotNull();
    }

    /**
     * <pre>
     * @Transactional를 통해서 트랜잭션 범위를 지정할 수 잇다. - ✨나중에 서비스단에 붙힘!!✨
     * - 서비스단에서 작성해야 할 어노테이션이다.
     * - EntityManager#getTransation().begin()
     * - EntityManager#getTransation().commit() / rollback() 코드 역할을 한다.
     * - 스프링의 테스트에 @Transactional을 적용하면, 기본적으로 마지막에 rollback처리한다.
     * - @Rollback(false)을 통해 DML을 실제 적용할 수 있다.( rollback 되지 않음))
     * </pre>
     */
    @Transactional // ✨트랜잭션 범위 때문에 사용되고, 원래는 rollback 처리 되지만
    @Rollback(false) // ✨ 얘 때문에 rollback처리되지 않음! -> 눈으로 확인하고 싶을 때 사용
    @Test
    @DisplayName("메뉴 가격 수정") // 🙉 jpa에서 수정할 때는 entity를 불러놓고 걔를 수정해야 함
    void test2() {
        // given
        Long menuCode = 10L; // 10번 메뉴 찾아서
        int newMenuPrice = 10000; // 가격 수정해줘~
        // when
        menuRepository.updateMenuPrice(menuCode, newMenuPrice);
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
         *         m1_0.menu_code=?
         */

        // then
        Menu menu = menuRepository.findByMenuCode(menuCode); // 영속성 컨텍스트에 있으니까 쿼리 안날라감
        assertThat(menu.getMenuPrice()).isEqualTo(newMenuPrice);
    }
}