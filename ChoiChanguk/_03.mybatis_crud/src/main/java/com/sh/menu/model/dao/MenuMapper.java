package com.sh.menu.model.dao;

import com.sh.menu.model.dto.MenuDto;

import java.util.List;

/**
 * <pre>
 * mybatis의 mapper.xml 쿼리를 참조하기 위한 dao 인터페이스
 * - 클래스명 -> mapper태그 namespace속성에 매칭
 * - 추상메소드명 -> 쿼리태그 (select, insert, update, delete)의 id속성
 * - 매개변수 -> 쿼리 #{변수명} 표현식에 대입
 * </pre>
 */
public interface MenuMapper {
    List<MenuDto> findAll();
    MenuDto findByMenuCode(int menuCode);

    int insertMenu(MenuDto menuDto);// DML(insert, update, delete)의 반환값은 int로 정해져있다
    int updateMenu(MenuDto menuDto);
    int deleteMenu(MenuDto menuDto);

    List<MenuDto> findByCategoryCode(int categoryCode);
}
