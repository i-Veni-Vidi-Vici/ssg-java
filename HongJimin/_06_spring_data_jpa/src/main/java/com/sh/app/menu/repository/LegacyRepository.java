package com.sh.app.menu.repository;

import com.sh.app.menu.entity.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

// 옛날 방식
@Repository // spring에 jpa만 얹으면 이렇게 써야 함!
public class LegacyRepository {
    @PersistenceContext // 얘를 붙혀도 autowired 붙힌것처럼 작동함
    private EntityManager em; // spring-data-jpa를 쓰면 이런거 안써도됨!

    public Menu findByMenuCode(Long menuCode) {
        return em.find(Menu.class, menuCode);
    }

    public void updateMenuPrice(Long menuCode, int newMenuPrice) {
        // 수정, 삭제시 해당 엔티티를 먼저 조회해야 한다.
        Menu menu = em.find(Menu.class, menuCode);
        menu.changeMenuPrice(newMenuPrice);
    }
}

//// ✨옛날 방식✨
//@Repository // spring에 jpa만 얹으면 이렇게 써야 함!
//public class LegacyRepository {
//    @PersistenceContext // 얘를 붙혀도 autowired 붙힌것처럼 작동함
//    private EntityManager em; // spring-data-jpa를 쓰면 이런거 안써도됨!
//
//    public Menu findByMenuCode(Long menuCode) {
//        return em.find(Menu.class, menuCode);
//    }
//
//    public void updateMenuPrice(Long menuCode, int newMenuPrice) {
//        // 수정, 삭제시 해당 엔티티를 먼저 조회해야 한다.
//        Menu menu = em.find(Menu.class, menuCode);
//        menu.changeMenuPrice(newMenuPrice);
//    }
//}
