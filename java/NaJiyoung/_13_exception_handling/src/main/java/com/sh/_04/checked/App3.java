package com.sh._04.checked;

import java.util.InputMismatchException;

/**
 * <pre>
 * 두 정수를 입력받고, 그 합을 출력하는 프로그램을 작성합니다.
 * - 정수가 아닌 숫자를 입력하면, "유효한 정수를 입력해주세요." 출력 후 다시 정상적으로 작동해야 합니다.
 * - Calculator#sum() 메소드를 작성하세요.
 *
 * 정수1 입력 : 20
 * 정수2 입력 : 30
 * 결과 : 50
 *
 * 정수1 입력 : ㅇㅇ
 * 유효한 정수를 입력해주세요.
 * 정수1 입력 : 20
 * 정수2 입력 : 30
 * 결과 : 50
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.sum();
        } catch(InputMismatchException e) {
            System.out.println("유효한 정수를 입력해주세요.");
        }
    }
}
