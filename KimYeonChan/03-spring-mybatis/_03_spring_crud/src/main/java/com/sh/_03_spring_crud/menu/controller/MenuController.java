package com.sh._03_spring_crud.menu.controller;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import com.sh._03_spring_crud.menu.model.dto.MenuRegistDto;
import com.sh._03_spring_crud.menu.model.service.MenuCommandService;
import com.sh._03_spring_crud.menu.model.service.MenuQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuQueryService menuService;
    private final MenuCommandService menuCommandService;

    @GetMapping("list")
    public void list(Model model) {
        log.info("GET /menu/list");

        // DB 에서 메뉴 목록을 조회 (List<MenuDto>) 후에 view 단 전달해야 한다.
        List<MenuDto> menus = menuService.findAll();
        model.addAttribute("menus", menus);
    }

    @GetMapping("regist")
    public void regist(Model model) {
        log.info("GET /menu/regist");

        List<CategoryDto> categories = menuService.findAllCategory();
        log.debug("categories: {}", categories);
        model.addAttribute("categories", categories);
    }

    /**
     * 거의 모든 POST 요청은 redirect 로 응답해야 한다.
     * - 등록/수정/삭제한다면, DML 쿼리를 수행하는 요청은 모두 POST 로 처리한다.
     * - url 변경하기(새로고침 이슈 방지하기) 위해서 필수적으로 처리해야 한다.
     */
    @PostMapping("/regist")
    public String regist(@ModelAttribute MenuRegistDto menuRegistDto) {
        log.info("POST /menu/regist");
        log.debug("menuRegistDto: {}", menuRegistDto);
        // 사용자 입력값 처리할 DTO 와 실제 DB 쿼리요청에 사용하는 dTO는 다를 수 있다.
        // 필요한 DTO로 데이터를 이전해서 서비스 작업을 진행한다.
        MenuDto menuDto = menuRegistDto.toMenuDto();
//        int resurlt = menuCommandService(menuDto);
        return "redirect:/menu/list";
    }
}
