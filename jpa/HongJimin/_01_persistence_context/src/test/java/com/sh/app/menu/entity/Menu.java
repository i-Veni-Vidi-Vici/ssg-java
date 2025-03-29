package com.sh.app.menu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DB tbl_menu와 1:1 매칭되는 entity 클래스
 * - (데이터지향 관점) FK 컬럼 tbl_menu.category_code를 직접 실제 컬럼 값으로 매칭했다. -> 이 전 까지는 데이터 지향적으로 봄
 * - (객체 지향 관점) FK 컬럼 값이 아닌, Category 객체를 참조해야 한다.
 * - db를 안배웠을 당시,객체 지향 관점으로 봣을 것
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Long menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode; // 데이터 지향 관점 -> 이전까지의 방법
//    private Category category; // 🌟객체 지향 관점 -> 앞으로 코딩할 방향🌟
    private String orderableStatus;
}
