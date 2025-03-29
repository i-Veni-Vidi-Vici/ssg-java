package com.sh.variable;

public class VariableApp {
    /**
     * 변수: 메모리상의 값을 보관하기 위한 공간
     * -값을 변수에 담아 사용하기 위한 목적
     * -값을 재사용
     * -시간에 따라 변하는 값을 처리
     * @param args
     */
    public static void main(String[] args) {
        //값에 의미를 부여
        System.out.println("보너스를 포함한 급여는 " + (1000000 + 10000) + "원 입니다.");
        int salary = 1000000;
        double bonus = salary*0.01;
        System.out.println("보너스를 포함한 급여는 " + (int)(salary + bonus) + "원 입니다.");

        //값을 재사용
        int point  = 100;
        System.out.println("1번 고객에게 " + point + "포인트를 지급합니다.");
        System.out.println("2번 고객에게 " + point + "포인트를 지급합니다.");
        System.out.println("3번 고객에게 " + point + "포인트를 지급합니다.");

        //시간에 따라 변하는 값을 처리
        // =(대입연산자/ 우항의 값을 좌항의 변수에 할당/ 연산자 우선순위 낮음), ==(비교연산자)

        int price = 0;
        System.out.println("총 금액: " + price+ "원");
        price += 10000; // 상품 추가
        System.out.println("총 금액: " + price + "원");
        price += 20000;
        System.out.println("총 금액: " + price + "원");


    }
}
