package com.sh._04.checked;



/**
 * 두 정수를 입력받고, 그 합을 출력하는 프로그램을 작성합니다.
 * - 정수가 아닌 숫자를 입력하면, " 유효한 정수를 입력해주세요." 출력후 다시 정상적으로 작동해야 한다.
 *
 * 정수 1 입력 : 20
 * 정수 2 입력 : 30
 * 결과 : 50
 *
 * 정수1 입력 : oo
 * 유효한 정수를 입력해주세요
 * 정수1 입력 : 20
 * 정수2 입력 : 30
 * 결과 : 50
 *
 *
 */


public class App3 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.sum();
        System.out.println("프로그램 정상 종료!");
    }
}
