package com.sh._01.java.config;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {


    @Select("""
        select 
            menu_code ,
            menu_name ,
            menu_price ,
            category_code ,
            orderable_status 
        from 
            tbl_menu
        where
            menu_code = #{menuCode}
""")
    com.sh.menu.model.dto.MenuDto findByMenuCode(int menuCode);

    @Select("select * from tbl_menu")
    List<com.sh.menu.model.dto.MenuDto> findAll();
}
