package com.sh.menu.view;

import com.sh.menu.controller.MenuController;
import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;


import java.util.Scanner;

/**
 * <pre>
 * View단
 * - 사용자인터페이스 담당
 * - 콘솔메뉴 제공, 사용자입력값 처리, 요청에 대한 응답 출력
 * - 사용자 요청에 따른 컨트롤러단에 메세지 전송
 * </pre>
 */
public class MenuView {
    private MenuController menuController = new MenuController();
    private Scanner sc = new Scanner(System.in);
    public void mainMenu() {
        String menu = """
                ========================
                1. 전체메뉴 조회
                2. 메뉴코드 조회
                3. 카테고리별 메뉴 조회
                4. 메뉴 등록
                5. 메뉴 수정
                6. 메뉴 삭제
                7. 카테고리 & 메뉴 등록
                8. 주문가능한 메뉴 조회
                9. 주문가능한 카테고리별 메뉴 조회
                0. 종료
                ========================
                입력 : """;
        while (true) {
            System.out.println(menu);
            String choice = sc.next();
            switch (choice) {
                case "1": menuController.findAll(); break;
                case "2": menuController.findByMenuCode(inputMenuCode()); break;
                case "3": menuController.findByCategoryCode(inputCategoryCode()); break;
                case "4": menuController.insertMenu(inputMenu()); break;
                case "5": menuController.updateMenu(updateMenu()); break;
                case "6": menuController.deleteMenu(inputMenuCode()); break;
                case "7": menuController.insertCategoryAndMenu(inputCategory(), inputMenu()); break;
                case "0": return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private CategoryDto inputCategory() {
        System.out.println("등록할 카테고리정보를 작성해주세요.");
        CategoryDto categoryDto = new CategoryDto();
        System.out.println("카테고리명 : ");
        categoryDto.setCategoryName(sc.next());
        categoryDto.setCategoryCode(0);
        System.out.println("부모카테고리코드 : ");
        categoryDto.setRefCategoryCode(sc.nextInt());
        return categoryDto;
    }

    private MenuDto inputMenu() {
        System.out.println("등록할 메뉴정보를 작성해주세요.");
        MenuDto menuDto = new MenuDto();
        System.out.println("메뉴코드 : ");
        menuDto.setMenuCode(sc.nextInt());
        System.out.println("메뉴명 : ");
        menuDto.setMenuName(sc.next());
        System.out.println("메뉴가격 : ");
        menuDto.setMenuPrice(sc.nextInt());
        findAllCategory();
        System.out.println("카테고리코드 : ");
        menuDto.setCategoryCode(sc.nextInt());
        System.out.println("주문가능여부(Y/N) : ");
        menuDto.setOrderableStatus(sc.next());
        return menuDto;
    }

    private MenuDto updateMenu() {
        int input = inputMenuCode();
        System.out.println("수정할 메뉴정보를 작성해주세요.");
        MenuDto menuDto = new MenuDto();
        menuDto.setMenuCode(input);
        System.out.println("메뉴명 : ");
        menuDto.setMenuName(sc.next());
        System.out.println("메뉴가격 : ");
        menuDto.setMenuPrice(sc.nextInt());
        findAllCategory();
        System.out.println("카테고리코드 : ");
        menuDto.setCategoryCode(sc.nextInt());
        System.out.println("주문가능여부(Y/N) : ");
        menuDto.setOrderableStatus(sc.next());
        return menuDto;
    }

    private int inputCategoryCode() {
        findAllCategory();
        System.out.print("조회할 카테고리코드를 입력하세요 : ");
        return sc.nextInt();
    }

    private int inputMenuCode() {
        System.out.print("메뉴코드를 입력하세요 : ");
        return sc.nextInt();
    }

    private void findAllCategory() {
        menuController.findAllCategory();
    }
}
