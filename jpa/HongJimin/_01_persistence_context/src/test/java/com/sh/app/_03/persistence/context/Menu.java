package com.sh.app._03.persistence.context;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;


/**
 * @Entity
 * - Entity의 이름(JPA 영속성 컨텍스트 상의 이름)
 * - 영속성 컨텍스트 안에 동일한 이름의 엔티티가 있을 수 없다.
 * - 클래스 레벨에 작성
 * - @Id 필드를 반드시 지정해야 한다.
 *
 * @Table
 * - Entity와 매칭되는 테이블 명 작성
 * - 클래스 레벨에 작성
 */
@Entity(name = "MyMenu") // 동일한 이름의 entity 객체가 존재할 수 없어서 바꿔줘야 함
@Table (name = "tbl_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate // 수정된 필드만 업데이트
public class Menu {
    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuCode;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_price")
    private int menuPrice;
    @Column(name = "category_code")
    private Long categoryCode; // null 값이 존재할 수 있으므로, 기본형이 아닌 wrapper 타입을 사용함
    @Column(name = "orderable_status")
    private String orderableStatus;
}
