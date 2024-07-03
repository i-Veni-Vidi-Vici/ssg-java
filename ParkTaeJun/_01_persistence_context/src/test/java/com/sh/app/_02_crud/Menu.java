package com.sh.app._02_crud;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 *tbl_menu 테이블과 1:1 매칭되는 entity 클래스
 * - (데이터지향관점) FK 컬럼 tbl_menu.category_code를 실제 컬럼값으로 매칭했다
 * - (객체지향관점) FK 컬럼값이 아닌 실제 Category객체를 참조해야한다.
 */

/**
 * @Entity
 *  - Entity의 이름 (JPA 영속성컨텍스트 상의 이름)
 *  - 영속성컨텍스트 안에 동일한 이름의 엔티티가 있을 수 없다.
 *  - Id필드를 반드시 지정해야 한다.
 *
 * @Table
 *  - Entity와 매칭되는 테이블명을 작성
 */
@Entity(name = "Menu") // Entity의 이름 (JPA 영속성컨텍스트 상의 이름), 영속성컨텍스트안에 동일한 이름의 엔티티가 있을 수 없다.
@Table(name = "tbl_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate // 수정된 필드만 업데이트
public class Menu {
    @Id
    @Column(name = "Menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 컬럼값 생성을 DB에 위임
    private Long menuCode;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_price")
    private int menuPrice;
    @Column(name = "category_code")
    private Long categoryCode; //데이터지향 관점 null 값이 존재할 수 있으므로, 기본형이 아닌 wrapper 타입을 사용한다.
//    private Category categoryCode; // 객체지향 관점
    @Column(name = "orderable_status")
    private String orderableStatus;
}
