package com.sh.menu.model.dao;



import com.sh.common.SearchCriteria;
import com.sh.menu.model.dto.MenuDto;

import java.util.List;


public interface MenuMapper {
    List<MenuDto> searchMenu(SearchCriteria searchCriteria);

    List<MenuDto> searchMenu2(SearchCriteria searchCriteria);

    List<MenuDto> searchMenu3();

    List<MenuDto> searchMenu4(SearchCriteria searchCriteria);
}
