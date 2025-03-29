package com.sh.app._08.namedquery;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Menu08")
@Table(name = "tbl_menu")
@NamedQueries({
        @NamedQuery(
                name = "_08.namedquery.Menu.findAll", // .점은 의미가 없고 이것은 문자열이다.
                query = """
                     select m from Menu08 m
                     """),
        @NamedQuery(
                name = "_08.namedquery.Menu.findByMenuName",
                query = """
                     select m from Menu08 m where m.menuName = :menuName
                     """),
        @NamedQuery(
                name = "_08.namedquery.Menu.findByMenuNameLike",
                query = """
                    select m from Menu08 m where m.menuName like concat('%', :menuName, '%')
                    """),
})
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
    // 다른 애그리게이트를 참조할 때는 PK컬럼으로 참조하기.
    @Column(name = "category_code")
    private Long categoryCode;
    @Column(name = "orderable_status")
    private String orderableStatus;
}
