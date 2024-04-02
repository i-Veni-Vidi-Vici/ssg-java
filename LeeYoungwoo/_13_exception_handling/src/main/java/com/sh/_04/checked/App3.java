package com.sh._04.checked;

import java.util.Scanner;

/**
 * <pre>
 * 두 정수를 입력받고, 그 합을 출력하는 프로그램을 작성
 * - 정수가 아닌 숫자를 입력하면, "유효한 정수를 입력해 주세요" 출력 후 다시 정상적으로 작동해야 한다.
 * - Calculator#sum()메소드를 작성하세요
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();
            calculator.sum();
            System.out.println("프로그램 정상 종료!");
        } catch (NumException e) {
            System.out.println("유효한 정수를 입력해 주세요...");
        }

    }
}
