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
@RequiredArgsConstructor
@Slf4j
public class MenuController {
    private final MenuService menuService;

    // 메뉴 목록 조회 & 페이징처리(페이지는 0페이지부터 시작한다)
    @GetMapping("/menuList")
    // view단에 보여주기 위해서 Model사용
    public void menuList(@PageableDefault(page = 0, size = 10) Pageable pageable, Model model){ // void로 했기 때문에 menu의 menuList를 반환한 것과 같다.
        log.info("GET /menu/menuList?page={}", pageable.getPageNumber());
        Page<Menu> menuPage = menuService.findAll(pageable);
        log.debug("menus = {}", menuPage.getContent());
        model.addAttribute("menus", menuPage.getContent()); // menuPage에서 content만 꺼내서 보기

        // 페이지 바 설정하는 코드
        int page = menuPage.getNumber();
        int limit = menuPage.getSize();
        int totalCount = (int) menuPage.getTotalElements(); // 전체 페이지 수
        String url = "menuList"; // 상대주소
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
    }
}
