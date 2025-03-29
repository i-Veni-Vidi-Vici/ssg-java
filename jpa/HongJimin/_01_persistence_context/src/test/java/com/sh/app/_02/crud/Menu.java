package com.sh.app._02.crud;

import com.sh.app.menu.entity.Category;
import jakarta.persistence.*; // 🌟여기에 모든 어노테이션이 잇음, hibernate-core에서 가져옴
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
@Entity(name = "Menu") // 이름 생략해도 됨
@Table (name = "tbl_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate // 수정된 필드만 업데이트
public class Menu {
    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  PK 컬럼값 생성을 DB에 위임(mysql은 autoincrement 처리가 가능해짐)
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
