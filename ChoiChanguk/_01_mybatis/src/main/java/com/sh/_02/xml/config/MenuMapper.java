package com.sh._02.xml.config;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper {
    MenuDto findByMenuCode(int menuCode);
    List<MenuDto> findAll();
}
