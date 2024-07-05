package com.sh.app.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * tbl_menu 테이블과 1:1 매칭되는 entity 클래스
 *  - (데이터 지향 관점) FK 컬럼 tbl_menu.category_code를 실제 컬럼 값으로 매칭했다.
 *  - (객체 지향 관점) FK 컬럼값이 아닌 실제 Category 객체를 참조해야 한다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Long menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode; // 데이터 지향 관점
//    private Category category; // 객체 지향 관점
    private String orderableStatus;
}
