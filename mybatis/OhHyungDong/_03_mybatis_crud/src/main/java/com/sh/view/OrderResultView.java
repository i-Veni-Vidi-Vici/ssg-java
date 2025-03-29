package com.sh.view;

public class OrderResultView {
    public static void displayResult(String type, int result) {
        if(result > 0)
            System.out.println("주문 성공 !");
        else {
            System.out.println("주문 실패 ㅠ_ㅠ");
        }
    }
}
