package com.sh.app.menu.repository;

import com.sh.app.menu.entity.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class LegacyMenuRepository {
    @PersistenceContext
    private EntityManager em;

    public Menu findByMenuCode(Long menuCode) {
        return em.find(Menu.class, menuCode);
    }

    //수정/삭제시 해당 엔티티를 먼저 조회해야 한다
    public int updateMenuPrice(Long menuCode, int newMenuPrice) {
        Menu menu=em.find(Menu.class,menuCode);
        menu.changeMenuPrice(newMenuPrice);
        return 0;
    }
}
