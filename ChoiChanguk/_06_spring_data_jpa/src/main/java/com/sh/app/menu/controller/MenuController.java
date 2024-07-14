package com.sh.app.menu.controller;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.paging.PageCriteria;
import com.sh.app.menu.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menuList")
    public void menuList(@PageableDefault(page = 0,size = 10) Pageable pageable, Model model) {
        log.info("GET /menu/menuList?page={}",pageable.getPageNumber());
        Page<Menu> menuPage=menuService.findAll(pageable);
        log.debug("menuPage={}",menuPage.getContent());

        int page=menuPage.getNumber();
        int limit=menuPage.getSize();
        long totalCount=menuPage.getTotalElements();
        String url="menuList"; // 상대주소
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
        model.addAttribute("menus",menuPage.getContent());

    }

}
