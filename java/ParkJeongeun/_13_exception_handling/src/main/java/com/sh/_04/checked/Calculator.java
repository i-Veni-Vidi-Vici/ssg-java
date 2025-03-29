package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator extends RuntimeException{
    Scanner sc = new Scanner(System.in);
    // (나) : 정수 1 잘 입력하고 정수 2를 잘못 입력했을때 정수1부터 다시 입력하게 됨..
//    public void sum() {
//        do {
//            try{
//                System.out.print("> 정수1 입력 : ");
//                int num1 = sc.nextInt();
//                System.out.print("> 정수2 입력 : ");
//                int num2 = sc.nextInt();
//                System.out.println("정수1 + 정수2 = " + (num1 + num2));
//                break;
//            } catch (InputMismatchException e){
//                System.out.println("유효한 정수를 입력해주세요.");
//            }
//        } while (true);
//    }
    // (모범답안)
    public void sum(){
        int m = inputNum(1);
        int n = inputNum(2);
        System.out.println("결과 : " + (m + n));
    }

    private int inputNum(int i) {
        while (true){
            try {
                System.out.print("> 정수" + i + " 입력 : ");
                return sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("유효한 정수를 입력하세요.");
                sc.next(); // 버퍼 문자열 제거
            }
        }
    }
}
