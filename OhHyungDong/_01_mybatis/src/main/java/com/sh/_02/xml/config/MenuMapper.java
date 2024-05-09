package com.sh._02.xml.config;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mybastis는 컬럼명하고 동일한 이름을 가진 자바 객체에다가 값을 대입함.
 */
public interface MenuMapper {


    MenuDto findByMenuCode(int menuCode);

    List<MenuDto> findAll();
}
