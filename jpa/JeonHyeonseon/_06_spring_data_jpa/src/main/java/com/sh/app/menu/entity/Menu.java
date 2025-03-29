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
    @Enumerated(EnumType.STRING) // y = 0, n = 1로 작성되는 데 문자열로 작성하는 것이 보기 편함
    private OrderableStatus orderableStatus;

    // 메뉴 가격 수정을 하고 싶지만 @Setter를 사용했기 때문에 직접 만든다.
    // Setter를 사용하지않으면 외부에서도 값을 수정할 수 있기 때문에 private으로 해야한다.
    public void changeMenuPrice(int newMenuPrice){
        this.menuPrice = newMenuPrice;
    }

    public void changeMenuName(String newMenuName) {
        this.menuName = newMenuName;
    }
}
