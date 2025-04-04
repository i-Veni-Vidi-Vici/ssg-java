package com.sh.app.menu.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_menu")
@Data
@Setter(AccessLevel.PRIVATE)
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
    @Column(name = "category_code")
    private Long categoryCode;
    @Column(name = "orderable_status")
    @Enumerated(EnumType.STRING) // 이걸 붙혀줘야 이넘에 쓴값 그대로 보여준다.(원래는 순서대로 0,1로 관리함)
    private OrderableStatus orderableStatus;

    public void changeMenuPrice(int newMenuPrice) {
        this.menuPrice = newMenuPrice;
    }

    public void changeMenuName(String newMenuName) {
        this.menuName = newMenuName;
    }
}
