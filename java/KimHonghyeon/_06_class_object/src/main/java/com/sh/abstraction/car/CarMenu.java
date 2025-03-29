package com.sh.abstraction.car;

import java.util.Scanner;

public class CarMenu {
    Scanner scanner = new Scanner(System.in);
    Driver driver = new Driver();
    public void menu(){
        //String 블록(여러줄, 들여쓰기 표현)
        String menu = """
                ====================
                자동차 운전 프로그램
                ====================
                1. 시동켜기
                2. 가속
                3. 감속
                4. 시동끄기
                ====================
                입력: 
                """;
        while (true){
            System.out.print(menu);
            String choice= this.scanner.nextLine();
            switch (choice){
                case "1":
                    driver.startEngine();
                    break;
                case "2":
                    driver.accelerate();
                    break;
                case "3":
                    driver.brake();
                    break;
                case "4":
                    driver.stopEngine();
                    break;
                case "0":return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }


}
