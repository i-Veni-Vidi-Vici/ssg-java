package com.sh.variable;

public class VariableApp {
    /**
     * 변수 - 메모리상의 값을 보관하기 위한 공간
     *
     * 변수의 사용목적
     * 1. 값을 변수에 담아 사용하기 위한 목적을 표현한다.
     * 2. 값을 재사용할 수 있다.
     * 3. 시간에 따라 변하는 값을 처리할 수 있다.
     */
    public static void main(String[] args) {
        // 1. 값에 의미를 부여한다.
        int salary = 1000000;
        int point = 300;
        double bonus = salary * 0.01;
        System.out.println("보너스를 포함한 급여는 " + (salary + bonus) + "원 입니다.");

        // 2. 값을 재사용 할 수 있다.
        System.out.println("1번 고객에게" + 200 + "포인트를 지급합니다.");
        System.out.println("1번 고객에게" + 200 + "포인트를 지급합니다.");
        System.out.println("1번 고객에게" + 200 + "포인트를 지급합니다.");

        System.out.println("1번 고객에게" + point + "포인트를 지급합니다.");
        System.out.println("1번 고객에게" + point + "포인트를 지급합니다.");
        System.out.println("1번 고객에게" + point + "포인트를 지급합니다.");
        System.out.println();

        // 3. 시간에 따라 변하는 값을 처리할 수 있다.
        int price = 0;
        System.out.println("총액은" + price + "원 입니다.");
        // 프로그래밍에서의 (=)대입연산자의 의미는 우항의 값을 좌항의 공간에 대입하라. 연산자 우선순위가 낮다.
        price = price + 10000; // 장바구니에 상품 추가
        System.out.println("총액은" + price + "원 입니다.");
        price = price + 20000; // 장바구니에 상품 추가
        System.out.println("총액은" + price + "원 입니다.");
    }
}
