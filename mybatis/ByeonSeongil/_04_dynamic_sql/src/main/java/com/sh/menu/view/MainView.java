package com.sh.menu.view;

import com.sh.common.SearchCriteria;
import com.sh.menu.controller.MenuController;

import java.util.List;
import java.util.Scanner;

public class MainView {
    private MenuController menuController = new MenuController();
    private Scanner sc = new Scanner(System.in);

    public static List<Integer> todayRecommendation(){
        return List.of(1, 11, 22);
    }

    public void mainMenu() {
        String menu = """
            ----------------------
            메뉴 검색 
            ----------------------
            1. 메뉴명 검색
            2. 카테고리 검색
            3. 가격대 검색
            ----------------------
            입력 : """;
        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            SearchCriteria searchCriteria = switch(choice) {
                case "1" -> inputMenuName();
                case "2" -> inputCategoryCode();
                case "3" -> inputPriceRange();
                default -> null;
            };
            if(searchCriteria != null) {
                menuController.searchMenu(searchCriteria);
            }
            else {
                System.out.println("> 잘못 입력하셨습니다.");
            }
        }
    }

    private SearchCriteria inputPriceRange() {
        System.out.println("> 가격 범위 입력 ");
        System.out.print("> 최소값 입력 :  ");
        int start = sc.nextInt();
        System.out.print("> 최대값 입력 :  ");
        int end = sc.nextInt();
        return new SearchCriteria("price", null, start, end);
    }

    private SearchCriteria inputMenuName() {
        System.out.print("> 검색할 메뉴명 입력 : ");
        return new SearchCriteria("name", sc.next(), null, null);
    }
    private SearchCriteria inputCategoryCode() {
        System.out.print("> 검색할 카테고리 번호 입력 : ");
        return new SearchCriteria("category", sc.nextInt(), null, null);
    }
}
