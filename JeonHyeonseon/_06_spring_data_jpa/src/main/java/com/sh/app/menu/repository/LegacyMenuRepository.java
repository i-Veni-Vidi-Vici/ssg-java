package com.sh.app.menu.repository;

import com.sh.app.menu.entity.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class LegacyMenuRepository {
    @PersistenceContext // @Autowired를 작성한 것처럼 작동된다.
    private EntityManager em;

    public Menu findByMenuCode(Long menuCode) {
        return em.find(Menu.class, menuCode); // 엔티티매니저야. Menu.class에서 menuCode를 find해줘
    }

    public void updateMenuPrice(Long menuCode, int newMenuPrice) {
        // 수정/삭제 해당 엔티티를 먼저 조회해야 한다.
        Menu menu = em.find(Menu.class, menuCode);
        menu.changeMenuPrice(newMenuPrice); // 메뉴의 가격을 수정해야 한다. 하지만 Menu클래스에서 Setter를 사용할 수 없기 때문에 직접 만든다.(Menu클래스 확인해보기)
    }
}
