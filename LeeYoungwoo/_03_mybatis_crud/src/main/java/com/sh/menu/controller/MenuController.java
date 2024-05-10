package com.sh.menu.controller;

import com.sh.common.ErrorView;
import com.sh.common.error.ErrorCode;
import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;
import com.sh.menu.model.service.MenuService;
import com.sh.menu.view.ResultView;

import java.util.List;

/**
 * <pre>
 * Controller
 * - mvc구조의 제어부
 * - view단으로 부터 사용자 요청 수집
 * - 사용자 요청에 적합한 Service 선정
 * - Service에 전달할 데이터를 가공 및 요청
 * - 응답에 대한 view처리
 * - 예외처리 (service, dao처리중에 발생된 예외수집, 로깅, 사용자 전달)
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
            ErrorView.displayError(ErrorCode.CREATE_ORDER_ERROR);
        }
    }

    public void findByMenuCode(int menuCode) {
        try {
            // 0~1개의 MenuDto 반환 : MenuDto
            MenuDto menuDto = menuService.findByMenuCode(menuCode);
            ResultView.displayMenu(menuDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void insertMenu(MenuDto menuDto) {
        int result = menuService.insertMenu(menuDto);
        ResultView.displayResult("메뉴 등록", result);
    }

    public void insertCategoryAndMenu(CategoryDto categoryDto, MenuDto menuDto) {
//        int result = menuService.insertCategoryAndMenu(categoryDto, menuDto);
//        ResultView.displayResult("카테고리 & 메뉴 등록", result);
    }

    public void findByCategoryCode(int categoryCode) {
        List<MenuDto> list = menuService.findByCategoryCode(categoryCode);
        ResultView.displayMenuList(list);
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
        List<CategoryDto> categoryList = menuService.findAllCategory();
        ResultView.displayCategoryList(categoryList);
    }

    public void findMenuOrderable() {
        List<MenuDto> list = menuService.findMenuOrderable();
        ResultView.displayMenuList(list);
    }

    public List<MenuDto> findMenuOrderableByCategoryCode(int categoryCode) {
        List<MenuDto> list = menuService.findMenuOrderableByCategoryCode(categoryCode);
        ResultView.displayMenuList(list);
        return list;
    }
}
