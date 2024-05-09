package com.sh.menu.view;

import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;

import java.util.List;

/**
 * <pre>
 * 요청 결과 출력 메소드 모음 (static)
 * </pre>
 */
public class ResultView {
    /**
     * n건의 메뉴조회
     * - 최소한 비어있는 리스트 반환 (조회결과가 0행인 경우)
     * @param list
     */
    public static void displayMenuList(List<MenuDto> list) {
        if(list.isEmpty()) {
            System.out.println("> 😭😭😭조회된 메뉴가 없습니다.😭😭😭");
        }
        else {
            System.out.println("---------------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\t%s\n", "Code", "Name", "Price", "Category", "Orderable");
            System.out.println("---------------------------------------------------");
            for(MenuDto menuDto : list) {
                System.out.printf("%d\t%-15s%s\t%d\t%s\n",
                        menuDto.getMenuCode(),
                        menuDto.getMenuName(),
                        menuDto.getMenuPrice(),
                        menuDto.getCategoryCode(),
                        menuDto.getOrderableStatus()
                );
            }
            System.out.println("---------------------------------------------------");
        }
    }

    /**
     * 조회결과가 없는 경우 null이 전달된다.
     * @param menuDto
     */
    public static void displayMenu(MenuDto menuDto) {
        if(menuDto == null) {
            System.out.println("> 😭😭😭조회된 메뉴가 없습니다.😭😭😭");
        }
        else {
            System.out.println("-----------------------------");
            System.out.println("Code : " + menuDto.getMenuCode());
            System.out.println("Name : " + menuDto.getMenuName());
            System.out.println("Price : " + menuDto.getMenuPrice());
            System.out.println("Category : " + menuDto.getCategoryCode());
            System.out.println("Orderable : " + menuDto.getOrderableStatus());
            System.out.println("-----------------------------");
        }
    }

    public static void displayResult(String type, int result) {
        System.out.println("> 📢📢📢" + type + " " + (result > 0 ? "성공!" : "실패!") + "📢📢📢");
    }


    public static void displayCategoryList(List<CategoryDto> categoryList) {
        System.out.print("> ");
        for(int i = 0; i < categoryList.size(); i++) {
            CategoryDto categoryDto = categoryList.get(i);
            System.out.printf("%d.%s ", categoryDto.getCategoryCode(), categoryDto.getCategoryName());
        }
        System.out.println();
    }
}
