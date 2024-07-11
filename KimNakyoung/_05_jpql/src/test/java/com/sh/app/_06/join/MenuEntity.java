package com.sh.app._06.join;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "MenuEntity")
@Table(name = "tbl_menu")
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_code")
    private Long menuCode;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_price")
    private int menuPrice;
    @ManyToOne // 많은 메뉴가 하나의 카테고리니깐
    @JoinColumn(name = "category_code")
    private Category category;
    @Column(name = "orderable_status")
    private String orderableStatus;

}
