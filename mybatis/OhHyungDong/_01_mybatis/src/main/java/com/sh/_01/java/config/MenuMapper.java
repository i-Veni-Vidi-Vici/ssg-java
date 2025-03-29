package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mybastis는 컬럼명하고 동일한 이름을 가진 자바 객체에다가 값을 대입함.
 */
public interface MenuMapper {

    @Select("""
    select 
        menu_code ,
        menu_name ,
        menu_price ,
        category_code ,
        orderable_status 
    from tbl_menu
    where menu_code = #{menuCode}

""")
    MenuDto findByMenuCode(int menuCode);

    @Select("select * from tbl_menu")
    List<MenuDto> findAll();
}
