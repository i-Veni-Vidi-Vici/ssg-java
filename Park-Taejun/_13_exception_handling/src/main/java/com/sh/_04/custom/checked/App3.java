package com.sh._04.custom.checked;

/**
 * 두 정수를 입력 받고, 그 합을 출력하는 프로그램을 작성합니다.
 * 정수가 아닌 숫자를 입력하면, "유효한 정수를 입력해주세요" 출력 후 다시 정상적으로 작동헤야 합니다.
 * Calculator#sum() 메소듣를 작성하세요
 */
public class App3 {
    public static void main(String[] args) {

        try {
            Caculator caculator = new Caculator();
            caculator.sum();

        }catch (NotValidNumber e) {
        }



        System.out.println("프로그램 정상 종료!");

    }
}
