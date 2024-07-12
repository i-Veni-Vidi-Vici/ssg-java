package com.sh.app.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Menu")
@Table(name = "tbl_menu")
@Data
@Setter(AccessLevel.PRIVATE)// 🙉 set을 한정해두고 여러군데에서 바뀔수 없도록 해주기! -> 책임을 한군데로 몰아주는 것 🙉
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_code")
    private Long menuCode;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_price")
    private int menuPrice;
    @Column(name = "category_code") // 다른 애그리것을 참조하는 것 -> pk를 들고 와서 참조하기
    private Long categoryCode;
    @Column(name = "orderable_status")
    @Enumerated(EnumType.STRING)
    private OrderableStatus orderableStatus;

    // 🙉책임을 누가 갖고 있는냐를 정확히 해주는 것이 오류를 해결하기가 쉬움!!
    public void changeMenuPrice(int newMenuPrice) {
        this.menuPrice = newMenuPrice;
    }

    public void changeMenuName(String newMenuName) {
        this.menuName = newMenuName;
    }

}
