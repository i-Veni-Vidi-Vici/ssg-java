package com.sh._04.checked;

/**
 * <pre>
 * 두 정수를 입력받고, 그 합을 출력하는 프로그램을 작성합니다.
 *  - 정수가 아닌 숫자를 입력하면, "유효한 정수를 입력해주세요" 출력 후 다시 정상적으로 작동해야 합니다.
 *  - Calculator#sum() 메소드를 작성하세요. Calculator = 클래스명, sum = 메소드
 *
 *  정수1 입력 : 20
 *  정수2 입력 : 30
 *  결과 : 50
 *
 *  정수1 입력 : 아아
 *  유효한 정수를 입력해주세요
 *  정수1 입력 : 21
 *  정수2 입력 : 8
 *  결과 : 29
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.sum();
        System.out.println("프로그램 정상 종료");
    }
}
