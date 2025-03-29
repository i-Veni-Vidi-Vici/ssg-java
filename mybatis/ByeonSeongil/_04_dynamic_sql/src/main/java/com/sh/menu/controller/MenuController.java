package com.sh.menu.controller;

import com.sh.common.SearchCriteria;
import com.sh.menu.common.ErrorView;
import com.sh.menu.model.dto.MenuDto;
import com.sh.menu.view.ResultView;

import java.util.List;

public class MenuController {
    private MenuService menuService = new MenuService();

    public List<MenuDto> searchMenu(SearchCriteria searchCriteria) {
        try {
            List<MenuDto> menuList = menuService.searchMenu(searchCriteria);
            ResultView.displayMenuList(menuList);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(e);
        }
        return null;
    }
}

