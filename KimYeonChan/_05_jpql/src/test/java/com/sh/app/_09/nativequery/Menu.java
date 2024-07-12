package com.sh.app._09.nativequery;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Menu09")
@Table(name = "tbl_menu")
@NamedNativeQuery(
        name = "_09.nativequery.Menu.findByMenuCode",
        query = """
            select
                *
            from
                tbl_menu m
            where
                m.code = ?
        """
)
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
