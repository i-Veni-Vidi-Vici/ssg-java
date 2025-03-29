package com.sh.app._04.jpql.grouping;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Menu04")
@Table(name = "tbl_menu")
@Data
@Setter(AccessLevel.PRIVATE)
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
    private String orderableStatus;

}
