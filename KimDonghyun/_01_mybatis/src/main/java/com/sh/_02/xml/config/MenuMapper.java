package com.sh._02.xml.config;

import java.util.List;

public interface MenuMapper {
    MenuDto findByMenuCode(int menuCode);
    List<MenuDto> findAll();
}
