package com.sh.app.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * tbl_menu테이블과 1:1 매칭되는 entity 클래스
 * - (데이터지향관점) FK 칼럼 tbl_menu.category_code를 실제 컬럼값으로 매칭했다.
 * - (객체지향관점) FK컬럼값이 아닌 실제 Category객체를 참조해야한다.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Long menuCode;
    private String menuName;
    private int menuPrice;
    private Category category; // 객체지향 관점
    private int CategoryCode; //데이터지향관점 // 이건 테이블이 만들어져있어서 따라 쓴거임
    private String OrderableStatus;
}
