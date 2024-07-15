package com.sh.app.menu.controller;

import com.sh.app.category.dto.CategoryResponseDto;
import com.sh.app.category.service.CategoryService;
import com.sh.app.common.paging.PageCriteria;
import com.sh.app.menu.dto.MenuCategoryResponseDto;
import com.sh.app.menu.dto.MenuRegistRequestDto;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j
public class MenuController {
    private final MenuService menuService;
    private final CategoryService categoryService;

    @GetMapping("/menuList")
    public void menuList(@PageableDefault(page = 1, size = 10) Pageable pageable, Model model){
        log.info("GET /menu/menuList?page={}", pageable.getPageNumber());
        // jpa의 Pageable은 0-based 페이지를 지원한다.
        // 사용자 입장에서 0페이지부터 시작하는 것은 어색하다.
        // Pageable은 0-based 페이지로 관리하고, 사용자에게 노출은 1-based페이지로 처리한다.
        pageable = PageRequest.of(
                    pageable.getPageNumber() - 1,
                    pageable.getPageSize());

        Page<Menu> menuPage = menuService.findAll(pageable);
        log.debug("menuPage = {}", menuPage.getContent());
        model.addAttribute("menus", menuPage.getContent());

        int page = menuPage.getNumber(); // 0-based 페이지번호
        int limit = menuPage.getSize();
        int totalCount = (int) menuPage.getTotalElements();
        String url = "menuList"; // 상대주소
        model.addAttribute("pageCriteria", new PageCriteria(page, limit, totalCount, url));
    }

    @GetMapping("/menuDetail")
    public void menuDetail(@RequestParam("menuCode") Long menuCode, Model model){
        MenuCategoryResponseDto menu = menuService.findByMenuCode(menuCode);
        log.debug("menu = {}", menu);
        model.addAttribute("menu", menu);
    }

    @GetMapping("/menuRegist")
    public void menuRegist(Model model){
        List<CategoryResponseDto> categories = categoryService.findByRefCategoryCodeIsNotNull();
        log.debug("categories = {}", categories);
        model.addAttribute("categories", categories);
    }

    @PostMapping("/menuRegist")
    public String menuRegist(
            MenuRegistRequestDto dto, RedirectAttributes redirectAttributes){
        log.debug("dto = {}", dto);
        menuService.regist(dto);
        redirectAttributes.addFlashAttribute("message", "메뉴를 등록했습니다.");
        return "redirect:/menu/menuList";
    }
}
