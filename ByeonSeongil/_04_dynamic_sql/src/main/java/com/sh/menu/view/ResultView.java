package com.sh.menu.view;

import com.sh.menu.model.dto.MenuDto;

import java.util.List;

public class ResultView {
    public static void displayMenuList(List<MenuDto> menuList) {
        System.out.println(menuList);
    }
}
