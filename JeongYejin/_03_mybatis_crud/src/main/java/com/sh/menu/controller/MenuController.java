package com.sh.menu.controller;

import com.sh.common.ErrorView;
import com.sh.common.error.ErrorCode;
import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;
import com.sh.menu.model.service.MenuService;
import com.sh.menu.view.ResultView;

import java.util.List;

import static com.sh.common.error.ErrorCode.FIND_ALL_MENU_ERROR;
import static com.sh.common.error.ErrorCode.FIND_A_MENU_ERROR;

/**
 * <pre>
 * Controller
 * - mvc구조의 제어부
 * - view단으로부터 사용자 요청 수집
 * - 사용자 요청에 적합한 Service 선정
 * - Service에 전달한 데이터를 가공 및 요청
 * - 응답에 대한 처리
 * - 예외처리 (service, dao 처리 중에 발생된 예외수집, 로깅, 사용자 전달)
 * </pre>
 */

public class MenuController {
    private MenuService menuService = new MenuService();

    public void findAll() {
        try {
            // n개의 MenuDto 반환 : List<MenuDto>
            List<MenuDto> list = menuService.findAll();
            ResultView.displayMenuList(list);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(FIND_ALL_MENU_ERROR);
        }
    }

    public void findByMenuCode(int menuCode) {
        try {
            // 0~1개의 MenuDto 반환 : MenuDto
            MenuDto menuDto = menuService.findByMenuCode(menuCode);
            ResultView.displayMenu(menuDto);
        } catch (Exception e) {
            ErrorView.displayError(FIND_A_MENU_ERROR);
        }
    }

    public void findByCategoryCode(int categoryCode) {
        List<MenuDto> list = menuService.findByCategoryCode(categoryCode);
        ResultView.displayMenuList(list);
    }

    public void insertMenu(MenuDto menuDto) {
        int result = menuService.insertMenu(menuDto);
        ResultView.displayResult("메뉴 등록", result);
    }

    public void insertCategoryAndMenu(CategoryDto categoryDto, MenuDto menuDto) {
//        int result = menuService.insertCategoryAndMenu(categoryDto, menuDto);
//        ResultView.displayResult("카테고리 & 메뉴 등록", result);
    }

    public void updateMenu(MenuDto menuDto) {
        int result = menuService.updateMenu(menuDto);
        ResultView.displayResult("메뉴 수정", result);
    }

    public void deleteMenu(int menuCode) {
        int result = menuService.deleteMenu(menuCode);
        ResultView.displayResult("메뉴 삭제", result);
    }

    public void findAllCategory() {
        List<CategoryDto> list = menuService.findAllCategory();
        ResultView.displayCategoryList(list);
    }

    public void findByOrderableStatus() {
        List<MenuDto> list = menuService.findByOrderableStatus();
        ResultView.displayMenuList(list);
    }

    public List<MenuDto> findByOrderableCategoryCode(int categoryCode) {
        List<MenuDto> list = menuService.findByOrderableCategoryCode(categoryCode);
        ResultView.displayMenuList(list);
        return list;
    }
}
