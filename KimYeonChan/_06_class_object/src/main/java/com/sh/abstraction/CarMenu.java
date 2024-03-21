package com.sh.abstraction;

import java.util.Scanner;

public class CarMenu {
    private Scanner sc = new Scanner(System.in); // 전역 변수

    public void menu() {
        Driver driver = new Driver();
        // String block 문법 (여러줄, 들여쓰기 표현 가능)
        String menu = """
                =========================
                    자동차 운전 프로그램
                =========================
                1. 시동켜기
                2. 가속
                3. 감속
                4. 시동끄기
                0. 종료
                =========================
                입력: """;

        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1": driver.startEngine(); break;
                case "2": driver.accelerate(); break;
                case "3": driver.brake(); break;
                case "4": driver.stopEngine(); break;
                case "0": return;
                default:
                    System.out.println("> 잘못 입력 하셨습니다.");
            }
        }
    }
}
