package com.sh.app._02.crud;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;


/**
 * @Entity
 *  - entity 이름(jpa 영속성 컨텍스트 상의 이름)
 *  - 영속성 컨텍스트 안에 동일한 이름의 엔티티가 있을 수 없다.
 *  - @Id 필드를 반드시 지정해야 한다.
 * @Table
 *  - Entity와 매칭되는 테이블명을 작성
 */
@Entity(name = "Menu")
@Table(name = "tbl_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate // 수정된 필드만 업데이트
public class Menu {
    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 컬럼값 생성을 DB에 위임(mysql은 auto_increment 처리)
    private Long menuCode;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_price")
    private int menuPrice;
    @Column(name = "category_code")
    private Long categoryCode; // 데이터 지향 관점
//    private Category category; // 객체 지향 관점
    @Column(name = "orderable_status")
    private String orderableStatus;
}
