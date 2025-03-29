package com.ssg.test.random.rcp;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 가위 바위 보 게임 ===");
        System.out.print("숫자를 선택하세요(1.가위/2.바위/3.보)");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Game.rockPaperScissors(n);

    }
}
