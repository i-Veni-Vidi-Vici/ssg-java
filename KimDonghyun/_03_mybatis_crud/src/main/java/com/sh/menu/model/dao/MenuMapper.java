package com.sh.menu.model.dao;

import com.sh.menu.model.dto.MenuDto;

import java.util.List;

/**
 * <pre>
 * mybatis의 mapper.xml 쿼리를 참조하기위한 dao인터페이스
 * - 클래스명 -> mapper태그 namespace속성
 * - 추상메소드명 -> 쿼리태그(select, insert, update, delete)의 id속성
 * - 매개변수 -> 쿼리의 #{변수명} 표현식에 대입
 * </pre>
 */
public interface MenuMapper {

    List<MenuDto> findAll();
    MenuDto findByMenuCode(int menuCode);

    int insertMenu(MenuDto menuDto);

    // 쿼리에 전달하는 객체는 무조건 1개여야 한다. 값이 여러개인 경우 DTO 또는 Map을 사용해야 한다.
//    int insertMenu(String menuName, int menuPrice, int categoryCode, String orderableStatus);
    int updateMenu(MenuDto menuDto);
    int deleteMenu(int menuCode);

    List<MenuDto> findByCategoryCode(int categoryCode);
}
