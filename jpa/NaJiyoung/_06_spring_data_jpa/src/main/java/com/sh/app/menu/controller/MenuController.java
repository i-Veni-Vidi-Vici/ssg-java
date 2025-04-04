package com.sh.app.menu.controller;

import com.sh.app.common.paging.PageCriteria;
import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/menuList")
    public void menuList(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model) {
        log.info("GET /menu/menuList?page={}", pageable.getPageNumber());
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize());
        Page<Menu> menuPage = menuService.findAll(pageable);
        log.debug("menuPage = {}", menuPage.getContent());
        model.addAttribute("menus", menuPage.getContent());

        int page = menuPage.getNumber();
        int limit = menuPage.getSize();
        int totalCount = (int) menuPage.getTotalElements();
        String url = "menuList"; // 상대주소
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
    }
}
