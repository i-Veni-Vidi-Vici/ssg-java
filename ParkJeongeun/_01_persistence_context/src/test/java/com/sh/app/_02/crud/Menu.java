package com.sh.app._02.crud;

import com.sh.app.menu.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity의 이름 (JPA 영속성 컨텍스트 상의 이름)
// 영속성 컨텍스트 안에 동일한 이름의 엔티티가 있을 수는 없음
// @Id필드를 반드시 지정해야함(지정하지 않으면 PK컬럼이 있어야된다는 오류뜸)
@Entity(name = "Menu")

// Entity와 매칭되는 테이블명 작성
@Table(name = "tbl_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    @Id
    @Column(name = "menu_code")

    // PK컬럼값 생성을 DB에 위임
    // mysql은 auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuCode;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_price")
    private int menuPrice;
    @Column(name = "category_code")
    private Long categoryCode; // null값이 존재할 수 있으므로 기본형이 아닌 wrapper타입 사용
    @Column(name = "orderable_status")
    private String orderableStatus;
}