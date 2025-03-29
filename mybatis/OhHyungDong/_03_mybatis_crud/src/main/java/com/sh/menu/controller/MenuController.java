package com.sh.menu.controller;


import com.sh.common.ErrorView;
import com.sh.common.error.ErrorCode;
import com.sh.menu.dto.CategoryDto;
import com.sh.menu.dto.MenuDto;
import com.sh.menu.service.MenuService;
import com.sh.view.ResultView;

import java.util.List;

/**
 * Controller
 * - mvc 구조의 제어탑
 * - view단으로 부터 사용자 요청 수집
 * - 사용자 요청에 적합한 Service 선정
 * - Service에서 전달할 데이터를 가공할
 * - 예외처리(service, dao 처리중에 발생된 예외수집, 로깅, 사용자 전달)
 */
public class MenuController {
    private MenuService menuService = new MenuService();

    public void findAll() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.FIND_ALL_MENU_ERROR);
        }
        // n개의 MenuDto 반환 : List<MenuDto>
        List<MenuDto> list =menuService.findAll();
        ResultView.dispalyMenuList(list);
    }

    public void findByMenuCode(int menuCode) {
        try {
            //0~1개의 MenuDto 반환 :
            MenuDto menuDto = menuService.findByMenuCode(menuCode);
            ResultView.dispalyMenu(menuDto);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.FIND_A_MENU_ERROR);
        }

    }

    public void insertMenu(MenuDto menuDto) {
        //DML : 처리된 행의 수 반환
       int result =  menuService.insertMenu(menuDto);
        ResultView.displayResult("메뉴 등록 ", result);
    }

    public void insertCategoryAndMenu(CategoryDto categoryDto, MenuDto menuDto) {
//        int result = menuService.insertCategoryAndMenu(categoryDto, menuDto);
//        ResultView.displayResult("카테고리 & 메뉴 등록 ", result);

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
