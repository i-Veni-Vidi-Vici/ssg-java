package com.sh._03_spring_crud.menu.controller;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import com.sh._03_spring_crud.menu.model.dto.MenuRegistDto;
import com.sh._03_spring_crud.menu.model.service.MenuCommandService;
import com.sh._03_spring_crud.menu.model.service.MenuQueryService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuCommandService menuCommandService;
    private final MenuQueryService menuQueryService;
    private final HttpServletRequest httpServletRequest;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("GET /menu/list");
        // DB에서 메뉴목록을 조회(List<MenuDto>)후에 view단 전달해야 한다.
        List<MenuDto> menus = menuQueryService.findAll();
        log.debug("menus = {}", menus);
        model.addAttribute("menus", menus);
    }

    @GetMapping("/regist")
    public void regist(Model model) {
        List<CategoryDto> categories = menuQueryService.getAllCategory();
        log.debug("categories = {}", categories);
        model.addAttribute("categories", categories);
    }

    /**
     * 거의 모든 post 요청은 redirect로 응답해야한다
     * - 등록/ 수정/ 삭제 과 같은 DML 요청은 모두 POST로 처리한다
     * - url을 변경 (새로고침 이슈 방지) 하기 위해서 필수적으로 처리해야 한다.
     * @return
     */
    @PostMapping("/regist")
    public String regist(@ModelAttribute MenuRegistDto menuRegistDto, RedirectAttributes redirectAttributes){
        log.info("POST /menu/regist");
        log.debug("menuDTO = {}", menuRegistDto);
        //사용자 입력처리할 DTO 실제 DTO를 매핑해줌
        MenuDto menuDto = menuRegistDto.toMenuDto();
        int result = menuCommandService.insertMenu(menuDto);
        redirectAttributes.addFlashAttribute("message", "메뉴를 성공적으로 등록했습니다😎");
        return "redirect:/menu/list";
    }

    @GetMapping("/detail/{menuCode}")
    public String regist(Model model, @PathVariable long menuCode){
        log.debug("GET /page/{}", menuCode);
        MenuDto menuDto = menuQueryService.findByMenuCode(menuCode);
        model.addAttribute("menu", menuDto);
        return "menu/detail";
    }
}
