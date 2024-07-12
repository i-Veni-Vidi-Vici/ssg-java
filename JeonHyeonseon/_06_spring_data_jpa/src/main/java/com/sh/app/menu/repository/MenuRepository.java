package com.sh.app.menu.repository;

import com.sh.app.menu.dto.IMenuCategoryResponseDto;
import com.sh.app.menu.dto.MenuCategoryResponseDto;
import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Long은 pk컬럼 타입
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // %로 감싸서 전달해야 한다
    List<Menu> findByMenuNameLike(String menuName); // 인터페이스끼리의 상속은 extends

    // %를 감싸지 않아도 전달된다
    List<Menu> findByMenuNameContaining(String menuName);

    List<Menu> findByMenuPriceGreaterThanEqual(int minMenuPrice);

    List<Menu> findByMenuPriceLessThanEqual(int maxMenuPrice);

    List<Menu> findByMenuPriceBetween(int minMenuPrice, int maxMenuPrice);

    List<Menu> findAllByOrderByMenuNameAsc();

    List<Menu> findAllByOrderByMenuNameDesc();

    List<Menu> findFirst5ByOrderByMenuPriceDesc();

    Page<Menu> findByOrderableStatus(OrderableStatus orderableStatus, Pageable pageable);

    List<Menu> findByCategoryCodeIn(List<Long> categoryCodes);

    @Query("""
        select
            new com.sh.app.menu.dto.MenuCategoryResponseDto(
            m.menuCode,
            m.menuName,
            c.categoryName)
        from
            Menu m left join Category c
                on m.categoryCode = c.categoryCode
        where
            m.menuCode = :menuCode
        """)
    MenuCategoryResponseDto findMenuAndCategory(@Param("menuCode") Long menuCode); // @Param("menuCode") 이것이 :menuCode 이거랑 맞아야한다.

    /**
     * Native Query 반환타입을 처리할 인터페이스 기반 DTO를 사용할 수 있다.
     * @param menuCode
     * @return
     */
    @Query(value = """
        select
            menu_code "menuCode",
            menu_name "menuName",
            (select category_name from tbl_category where category_code = m.category_code) "categoryName"
        from
            tbl_menu m
        where
            menu_code = ?
        """, nativeQuery = true) // nativeQuery = true w적으면 이 안에 일반 sql도 작성할 수 있다.
    IMenuCategoryResponseDto findMenuAndCategoryWithSQL(@Param("menuCode") Long menuCode); // @Param("menuCode") 이것이 :menuCode 이거랑 맞아야한다.
}
