package com.sh.app._02.crud;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *  @Entity : Entity의 이름(jpa 영속성컨텍스트 상의 이름_
 *  - 영속성컨텍스트안에 동일한 이름의 엔티티가 잇을 수 없다
 *
 *  @Id필드를 반드시 지정해야 한다 = pk컬럼
 *
 *  아래 어노테이션은 jakarta.persistence 에서 가져와서 쓰는거다. 이것은 hibernate에 들어있다
 */

@Entity(name="Menu") //
@Table(name = "tbl_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate // 수정된 필드만 업데이트
public class Menu {
    @Id
    // auto_increment일 때, pk컬럼값 생성을 db에 위임하는거다, (mysql으 auto_increment처리가 된다)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_code")
    private Long menuCode;

    @Column(name="menu_name")
    private String menuName;

    @Column(name="menu_price")
    private int menuPrice;

    @Column(name = "category_code")
    private Long categoryCode; // null값이 존재할 수 있으므로, 기본형이 아닌 wrapper타입을 사용한다

    @Column(name="orderable_status")
    private String orderableStatus;
}
