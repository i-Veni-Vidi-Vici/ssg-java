package com.sh.app.menu.controller;

import com.sh.app.common.paging.PageCriteria;
import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/menu")
@Slf4j
@RequiredArgsConstructor // @Autowired 붙히거나 @RequiredArgsConstructor + final붙히면 됨
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/menuList")
    public void menuList(@PageableDefault(page = 0, size = 10)Pageable pageable, Model model) { // view단에 전달할거여서 model 필요
        log.info("GET /menu/menuList?page={}", pageable.getPageNumber());
        //🙉여기랑
        Page<Menu> menuPage = menuService.findAll(pageable);
        log.debug("menus = {}", menuPage.getContent());
        model.addAttribute("menus", menuPage.getContent());

        //🙉여기 따로 생각하기!🙉
        int page = menuPage.getNumber();
        int limit = menuPage.getSize();
        int totalCount = (int) menuPage.getTotalElements();
        String url = "menuList"; // 상대 주소
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
    }
}
