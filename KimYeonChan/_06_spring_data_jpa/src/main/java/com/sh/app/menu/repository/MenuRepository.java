package com.sh.app.menu.repository;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByMenuNameLike(String menuName); // %로 감싸서 전달해야 함.

    List<Menu> findByMenuNameContaining(String menuName);

    List<Menu> findByMenuPriceGreaterThanEqual(int minMenuPrice);

    List<Menu> findByMenuPriceLessThanEqual(int maxMenuPrice);

    List<Menu> findByMenuPriceBetween(int minMenuPrice, int maxMenuPrice);

    List<Menu> findAllByOrderByMenuNameAsc();

    List<Menu> findAllByOrderByMenuNameDesc();

    List<Menu> findFirst5ByOrderByMenuPriceDesc();

    Page<Menu> findByOrderStatus(OrderableStatus orderableStatus, Pageable pageable);

    List<Menu> findByCategoryCodeIn(List<Long> categoryCodes);
}
