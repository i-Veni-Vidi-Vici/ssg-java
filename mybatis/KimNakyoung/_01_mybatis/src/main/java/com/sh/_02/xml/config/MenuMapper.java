package com.sh._02.xml.config;

import com.sh._02.xml.config.MenuDto;

import java.util.List;

public interface MenuMapper {

//    @Select("""
//        select
//        menu_code ,
//        menu_name ,
//        menu_price ,
//        category_code ,
//        orderable_status
//        from
//        tbl_menu
//        where
//        menu_code = #{menuCode}
//
//        """)

    MenuDto findByMenuCode(int menuCode);

//    @Select("select * from tbl_menu")
    List<MenuDto> findAll();

}
