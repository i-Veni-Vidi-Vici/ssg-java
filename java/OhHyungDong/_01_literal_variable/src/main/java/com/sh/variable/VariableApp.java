package com.sh.variable;

public class VariableApp
{
    /**
     * 변수 : 메모리상의 값을 보관하기 위한 공간
     * 변수의 사용 목적
     * 1. 값을 변수에 담아서 사용하기 위한 목적을 표현
     * 2. 값을 변수에 담으면 재사용 할 수 있음.
     * 3. 시간에 따라 변하는 값을 처리 할 수 있음.
     * @param args
     */
    public static void main(String[] args) {
        // 1. 값의 의미 부여
        System.out.println("보너스 포함한 급여는 " + (1000000 + 10000)+ "원 입니다. ");
        int salary = 1000000;
        double bonus = salary * 0.01;

        System.out.println("보너스 포함한 급여는 " + (int)(salary + bonus)+ "원 입니다. ");
        System.out.println();
        //2. 값을 재사용
        System.out.println("1번 고객에게" + 100 + "포인트를 지급합니다.");
        System.out.println("2번 고객에게" + 100 + "포인트를 지급합니다.");
        System.out.println("3번 고객에게" + 100 + "포인트를 지급합니다.");
        System.out.println();

        int point = 100;
        System.out.println("1번 고객에게" + point + "포인트를 지급합니다.");
        System.out.println("2번 고객에게" + point + "포인트를 지급합니다.");
        System.out.println("3번 고객에게" + point + "포인트를 지급합니다.");
        System.out.println();

        //3. 시간에 따라 값을 처리 할 수 있음.
        int price = 0;
        System.out.println("총액은 " + price + "원 입니다.");
        // = 대입연산자 - 우항의 값 -> 좌항의 값에 대입, 연산자 우선순위가 낮음.
        price += 10000; //장바구니 상품 추가
        System.out.println("총액은 " + price + "원 입니다.");
        price += 20000; //장바구니 상품 추가
        System.out.println("총액은 " + price + "원 입니다.");

    }
}
