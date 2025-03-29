package com.sh.menu.view;

import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;

import java.util.List;

public class ResultView {
    public static void displayMenuList(List<MenuDto> list) {
        if (list.isEmpty()) {
            System.out.println("> 조회된 메뉴가 없습니다.😱");
        } else {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("menu_code\tmenu_name\tmenu_price\tcategory_code\torderable_satus");
            System.out.println("--------------------------------------------------------------------------------------");
            for(MenuDto menuDto : list) {
                System.out.printf("%d\t%s\t%d\t%d\t%s",
                        menuDto.getMenuCode(),
                        menuDto.getMenuName(),
                        menuDto.getMenuPrice(),
                        menuDto.getCategoryCode(),
                        menuDto.getOrderableStatus());
                System.out.println();
            }
        }
    }

    public static void displayCategoryList(List<CategoryDto> list) {
        if (list.isEmpty()) {
            System.out.println("> 조회된 카테고리가 없습니다.😱");
        } else {
//            System.out.println("--------------------------------------------------------------------------------------");
//            System.out.println("category_code\tcategory_name");
//            System.out.println("--------------------------------------------------------------------------------------");
            for(CategoryDto categoryDto : list) {
                System.out.printf("%d.%s\t",
                        categoryDto.getCategoryCode(),
                        categoryDto.getCategoryName());
            }
            System.out.println();
        }
    }

    public static void displayMenu(MenuDto menuDto) {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("menu_code\tmenu_name\tmenu_price\tcategory_code\torderable_satus");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%d\t%s\t%d\t%d\t%s",
                menuDto.getMenuCode(),
                menuDto.getMenuName(),
                menuDto.getMenuPrice(),
                menuDto.getCategoryCode(),
                menuDto.getOrderableStatus());
        System.out.println();
    }

    public static void displayResult(String type, int result) {
        System.out.println("> 📢📢📢 " +
                type +
                (result > 0 ? "성공!" : "실패!") +
                "📢📢📢");
    }
}
