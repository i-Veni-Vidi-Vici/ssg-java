package com.sh._03_spring_crud.menu.controller;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto2;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuQueryService menuService;
    private final MenuCommandService menuCommandService;


//    @GetMapping("/list")
//    public void list(Model model) {
//        log.info("GET /menu/list");
//        // DB에서 메뉴목록을 조회(List<MenuDto>)후에 view단에 전달해야 한다.
//        List<MenuDto> menus = menuService.findAll();
//        log.debug("menus = {}",menus);
//        model.addAttribute("menus",menus);
//    }

    @GetMapping("/list")
    public void list(Model model) {
        log.info("GET /menu/list");
        // DB에서 메뉴목록을 조회(List<MenuDto>)후에 view단에 전달해야 한다.
        List<MenuDto2> menus = menuService.findAll2();
        log.debug("menus = {}",menus);
        model.addAttribute("menus",menus);
    }

    @GetMapping("/regist")
    public void regist(Model model) {
        log.info("GET /menu/regist");

        List<CategoryDto> categories=menuService.findAAllCategory();
        log.debug("category = {}",categories);

        model.addAttribute("categories",categories);
    }

    /**
     * 거의 모든 Post요청은 redirect로 응답해줘야 한다.
     * - 등록/수정/삭제한다면, 다시말해 DML쿼리르 수행하는 요청은 모두 POST로 처리한다
     * - URL 변경(새로고침 이슈 방지)하기 위해서 필수적으로 처리해야 한다.
     * @param model
     * @return
     */
    @PostMapping("/regist")
    public String regist(@ModelAttribute MenuRegistDto menuRegistDto, RedirectAttributes redirectAttributes){
        log.info("POST /menu/regist");
        log.debug("menuRegistDto = {}", menuRegistDto);
        // 사용자입력값처리할 DTO와 실제 DB쿼리요청에 사용하는 DTO는 다를 수 있다.
        // 필요한 DTO로 데이터를 이전해서 서비스작업을 진행한다.
        MenuDto menuDto = menuRegistDto.toMenuDto();
        int result = menuCommandService.insertMenu(menuDto);
        redirectAttributes.addFlashAttribute("message", "메뉴를 성공적으로 등록했습니다.👏👏👏");
        return "redirect:/menu/list";
    }


}
