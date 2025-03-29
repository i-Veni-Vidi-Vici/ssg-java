package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {

    @Select("""
    select 
        menu_code,
        menu_name,
        menu_price,
        category_code,
        orderable_status
    from tbl_menu 
    where menu_code = #{menuCode}
    """)
    MenuDto findByMenuCode(int menuCode);

    @Select("""
    select *
    from tbl_menu
    where category_code = #{categoryCode}
    """)
    MenuDto findByCategoryCode(int categoryCode);

    @Select("""
    select *
    from tbl_menu
    order by menu_code
    """)
    List<MenuDto> findAll();
}
