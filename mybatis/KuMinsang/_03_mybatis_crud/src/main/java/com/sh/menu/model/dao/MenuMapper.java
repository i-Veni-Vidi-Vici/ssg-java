package com.sh.menu.model.dao;

import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;

import java.util.List;

/**
 * <pre>
 *     mybatis의 mapper.xml쿼리를 참조하기 위한 dao 인터페이스
 *     - 클래스명 ->mapper 태그 namespace 속성
 *     - 추상메소드명 -> 쿼리태그 (select, insert, update, delete)의 id 속성
 *     - 매개변수 -> 쿼리의 #{변수명} 표현식에 대입
 *
 * </pre>
 */
public interface MenuMapper {
    List<MenuDto> findAll();
    MenuDto findByMenuCode(int menuCode);
    List<MenuDto> findByCategoryCode(int categoryCode);
    //쿼리에 전달하는 객체는 무조건 1개여야 한다. 값이 여러개인 경우 DTO는 key value로 전달하는것이 좋다
    int insertMenu(MenuDto menuDto);
    int insertCategory(CategoryDto categoryDto);
    int updateMenu(MenuDto menuDto);
    int deleteMenu(int menuCode);
    List<CategoryDto> displayAllCategory();
    List<MenuDto> findMenuOrderable();
    List<MenuDto> findMenuOrderableByCategoryCode(int categoryCode);
}
