package com.sh._04.checked;

import java.util.InputMismatchException;

/**
 *  두 정수 입력받고, 그 합 출력
 *  - 정수 아닌 순자 입력하면,"유효한 정수를 입력해주세요." 출력 후 다시 정상 작동
 *
 * Calculator#sum() 메소드 작성
 */
public class App3 {
    public static void main(String[] args) {
        try{
            Calculator calculator = new Calculator();
            calculator.sum();
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        System.out.println("프로그램 정상 종료");
    }
}
