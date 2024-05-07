package com.sh.menu.view;

import com.sh.menu.controller.MenuController;
import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;
import java.util.Scanner;

/**
 * <pre>
 * View 단
 * - 사용자인터페이스 담당
 * - 콘솔메뉴 제공, 사용자입력값 처리, 요청에 대한 응답 출력
 * - 사용자 요청에 따른 컨트롤러단에 메시지 전송
 * </pre>
 */
public class MenuView {
    private MenuController menuController = new MenuController();
    private Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        String menu = """
                =====================            
                1. 전체메뉴 조회
                2. 메뉴코드 조회
                3. 카테고리별 메뉴 조회
                4. 메뉴 등록
                5. 메뉴 수정
                6. 메뉴 삭제
                7. 카테고리 & 메뉴 등록
                0. 종료
                =====================            
                입력 : """;
        while (true) {
            System.out.println(menu);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    menuController.findAll();
                    break;
                case "2":
                    menuController.findByMenuCode(inputMenuCode());
                    break;
//                case "3":
//                    menuController.findByCategoryCode();
//                    break;
                case "4":
                    menuController.insertMenu(inputMenu());
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    menuController.insertCategoryAndMenu(inputCategory(), inputMenu());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }

    }

    private CategoryDto inputCategory() {
        System.out.println("> 등록할 카테고리 정보를 작성해주세요. 🎈");
        System.out.println("> 카테고리명 : ");
        String categoryName = sc.next();
        System.out.println("> 부모카테고리코드 : ");
        int refCategoryCode = sc.nextInt();
        return new CategoryDto(0, categoryName, refCategoryCode);
    }

    private MenuDto inputMenu() {
        System.out.println("> 등록할 메뉴정보를 작성해주세요. 🎈");
        System.out.println("> 메뉴명 : ");
        String menuName = sc.next();
        System.out.println("> 메뉴가격 : ");
        int menuPrice = sc.nextInt();
        System.out.println("> 카테고리코드 : ");
        int categoryCode = sc.nextInt();
        System.out.println("> 주문가능여부(Y/N) : ");
        String orderableStatus = String.valueOf(sc.next().toUpperCase().charAt(0));
        return new MenuDto(0, menuName, menuPrice, categoryCode, orderableStatus);
    }

    private int inputMenuCode() {
        System.out.print("> 조회할 메뉴코드 : ");

        return sc.nextInt();
    }
}
