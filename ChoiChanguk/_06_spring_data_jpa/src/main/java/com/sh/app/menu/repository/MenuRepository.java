package com.sh.app.menu.repository;

import com.sh.app.menu.dto.MenuCategoryResponseDto;
import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByMenuNameLike(String menuName);

    List<Menu> findByMenuNameContaining(String menuName);

    List<Menu>  findByMenuPriceGreaterThanEqual(int minMenuPrice);

    List<Menu> findByMenuPriceLessThanEqual(int minMenuPrice);

    List<Menu> findByMenuPriceBetween(int maxMenuPrice, int menuPrice);

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
    MenuCategoryResponseDto findMenuAndCategory(@Param("menuCode")Long menuCode);

}
