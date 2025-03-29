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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuQueryService menuQueryService;
    private final MenuCommandService menuCommandService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("GET /menu/list");
        // DB에서 메뉴목록을 조회(List<MenuDto>) 후에 view단에 전달해야 한다.
        List<MenuDto> menus = menuQueryService.findAll();
        model.addAttribute("menus", menus);
    }

    @GetMapping("/regist")
    public void regist(Model model) {
        log.info("GET /menu/regist");
        List<CategoryDto> categoryDtos = menuQueryService.findAllCategory();
        log.debug("categoryDtos = {}", categoryDtos);
        model.addAttribute("categoryDtos", categoryDtos);
    }

    /**
     * 거의 모든 POST요청은 redirect로 응답해야 한다.
     *  - 등록/수정/삭제한다면, 다시말해 DML쿼리를 수행하는 요청은 모두 POST로 처리한다.
     *  - why? url을 변경(새로고침 이슈 방지)하기 위해서 필수적으로 처리해야 한다.
     */
    @PostMapping("/regist")
    public String regist(@ModelAttribute MenuRegistDto menuRegistDto, RedirectAttributes redirectAttributes) {
        log.info("POST /menu/regist");
        log.debug("menuDto = {}", menuRegistDto);
        // 사용자 입력값을 처리할 Dto와 실제 DB쿼리요청에 사용하는 Dto는 다를 수 있다.
        // 필요한 Dto로 데이터를 이전해서 서비스 작업을 진행한다.
        MenuDto menuDto = menuRegistDto.toMenuDto();
        int result = menuCommandService.insertMenu(menuDto);
        redirectAttributes.addFlashAttribute("message", "메뉴를 성공적으로 등록했습니다.👏👏👏");
        return "redirect:/menu/list";
    }

    @GetMapping("/detail/{menuCode}")
    public String detail(@PathVariable Long menuCode, Model model){
        log.info("GET /detail/{}", menuCode);
        MenuDto menu = menuQueryService.findByMenuCode(menuCode);
        model.addAttribute("menu", menu);
        return "menu/detail";
    }
}
