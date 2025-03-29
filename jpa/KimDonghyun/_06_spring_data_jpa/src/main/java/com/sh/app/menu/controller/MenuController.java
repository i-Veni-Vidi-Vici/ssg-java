package com.sh.app.menu.controller;

import com.sh.app.category.dto.CategoryResponseDto;
import com.sh.app.category.service.CategoryService;
import com.sh.app.common.paging.PageCriteria;
import com.sh.app.menu.dto.*;
import com.sh.app.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
@RequiredArgsConstructor
@Slf4j
public class MenuController {
    private final MenuService menuService;
    private final CategoryService categoryService;

    @GetMapping("/menuList")
    public void menuList(@PageableDefault(page = 1, size = 10) Pageable pageable,
                         @RequestParam(required = false) String q,
                         Model model){
        log.info("GET /menu/menuList?page={}", pageable.getPageNumber());
        
        // 1. 컨텐츠영역 
        // jpa의 Pageable은 0-based 페이지를 지원한다.
        // 사용자 입장에서 0페이지부터 시작하는 것은 어색하다.
        // Pageable은 0-based 페이지로 관리하고, 사용자에게 노출은 1-based페이지로 처리한다.
        pageable = PageRequest.of(
                    pageable.getPageNumber() - 1,
                    pageable.getPageSize());

        Page<MenuListResponseDto> menuPage = menuService.findAll(q, pageable);
        log.debug("menuPage = {}", menuPage.getContent());
        model.addAttribute("menus", menuPage.getContent());

        // 2. 페이지바 영역
        int page = menuPage.getNumber(); // 0-based 페이지번호
        int limit = menuPage.getSize();
        int totalCount = (int) menuPage.getTotalElements();
        String url = "menuList"; // 상대주소
        if(q != null)
            url += "?q=" + q;
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
            @ModelAttribute MenuRegistRequestDto dto,
            RedirectAttributes redirectAttributes){
        log.debug("dto = {}", dto);
        menuService.regist(dto);
        redirectAttributes.addFlashAttribute("message", "메뉴를 등록했습니다.");
        return "redirect:/menu/menuList";
    }

    @GetMapping("/menuUpdate")
    public void menuUpdate(@RequestParam Long menuCode, Model model){
        MenuDetailResponseDto dto = menuService.findById(menuCode);
        log.debug("dto = {}", dto);
        List<CategoryResponseDto> categories = categoryService.findByRefCategoryCodeIsNotNull();
        model.addAttribute("menu", dto);
        model.addAttribute("categories", categories);
    }

    @PostMapping("/menuUpdate")
    public String menuUpdate(@ModelAttribute MenuUpdateRequestDto dto, RedirectAttributes redirectAttributes){
        menuService.update(dto);
        redirectAttributes.addFlashAttribute("message", "메뉴를 수정했습니다.");
        return "redirect:/menu/menuDetail?menuCode=" + dto.getMenuCode();
    }

    @PostMapping("/menuDelete")
    public String menuDelete(@RequestParam Long menuCode, RedirectAttributes redirectAttributes) {
        menuService.delete(menuCode);
        redirectAttributes.addFlashAttribute("message", "메뉴를 삭제했습니다.");
        return "redirect:/menu/menuList";
    }
}
