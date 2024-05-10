package com.sh.menu.dao;

import com.sh.menu.dto.MenuDto;

import java.util.List;

/**
 * mybatis의 mapper.xml 쿼리를 참조하기 위한 dao 인터페이스
 * - 클래스명 -> <mapper namespace = 속성과 매칭></mapper>
 * - 추상 메소드명 -> 쿼리 태그 (select, inert,update, delete)의 id 속성과 일치
 * - 매개변수 -> 쿼리의 #{변수명} 표현식에 대입
 */
public interface MenuMapper {

    List<MenuDto> findAll();

    MenuDto findByMenuCode(int menuCode);

    List<MenuDto> findByCategoryCode(int categoryCode);

    //쿼리에 전달하는 객체는 무조건 1개여야 한다. 값이 여러개인 경우 DTO 또는 Map을 사용해야 한다.
//    int insertMenu(String menuName,int menuPrice,int categoryCode)
    int insertMenu(MenuDto menuDto);
    int updateMenu(MenuDto menuDto);
    int deleteMenu(int menuCode);
}
