package com.sh._04.checked;

/**
 * 두 정수를 입력 받고, 그 합을 출력하는 프로그램을 작성합니다.
 *  - 정수가 아닌 숫자를 입력하면, "유효한 정수를 입력해주세요." 출력후 정상적으로 동작해야합니다.
 *  - Calculator#sum() 메소드를 작성하세요.
 */
public class App3 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.sum();
        System.out.println("프로그램 종료");
    }
}
