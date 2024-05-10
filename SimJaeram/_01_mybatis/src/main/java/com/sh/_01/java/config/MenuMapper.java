package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {

    @Select("""
        select
            menu_code "menuCode", 
            menu_name "menuName",
            menu_price "menuPrice", 
            category_code "category_code",
            orderable_status "orderableStatus"
        from
            tbl_menu
        where
            menu_code = #{menuCode}
    """)
    MenuDto findByMenuCode(int menuCode);

    @Select("select * from tbl_menu")
    List<MenuDto> findAll();
}
