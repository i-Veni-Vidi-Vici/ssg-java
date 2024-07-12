package com.sh.app._08.namedquery;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Menu08")
@Table(name = "tbl_menu")
@NamedQueries({
        @NamedQuery(
                name = "_08.namedquery.Menu.findAll",
                query = """
                select m from Menu08 m
                """),
        @NamedQuery(
                name = "_08.namedquery.Menu.findByMenuName",
                query = """
                select m from Menu08 m where m.menuName = :menuName  
                """), // 🙉 :menuName -> 변수 자리
        @NamedQuery(
                name = "_08.namedquery.Menu.findByMenuNameLike",
                query = """
                select m from Menu08 m where m.menuName like concat('%', :menuName, '%')
                """)
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
    @Column(name = "category_code") // 다른 애그리것을 참조하는 것 -> pk를 들고 와서 참조하기
    private Long categoryCode;
    @Column(name = "orderable_status")
    private String orderableStatus;
}
