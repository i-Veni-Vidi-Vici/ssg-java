package com.sh.app.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.result.UpdateCountOutput;

@Entity
@Table(name = "tbl_menu")
@Data
@Setter(AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private OrderableStatus orderableStatus;

    public void changeMenuPrice(int newMenuPrice)
    {
        this.menuPrice=newMenuPrice;
    }


    public void changeMenuName(String menuName) {
        this.menuName=menuName;
    }
}
