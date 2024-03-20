package com.sh.custom.type.abstraction;

import java.util.Scanner;

public class CarMenu {
    private Scanner sc = new Scanner(System.in);
    public void menu(){
        //String block 문법 (여러줄, 들여쓰기 표현가능)
        String menu = """
                ===========================
                자동차 운전 프로그램
                ===========================
                1. 시동켜기
                2. 가속
                3. 감속
                4. 시동끄기
                0. 종료
                ===========================
                입력 : """;

        while(true){
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" :
                    break;
                case "2" :
                    break;
                case "3" :
                    break;
                case "4" :
                    break;
                case "0" :
                    return;
                default :
                    System.out.println("잘못 입력하셨습니다.");


            }
        }

    }
}
