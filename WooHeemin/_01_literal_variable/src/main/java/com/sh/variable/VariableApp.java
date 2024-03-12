package com.sh.variable;

public class VariableApp {
    /**
     *  변수 - 메모리상의 값을 보관하기 위한 공간
     *
     *  변수의 사용목적
     *  1. 값을 변수에 담아 사용하기 위한 목적을 표현
     *  2. 값을 재사용할 수 있다.
     *  3. 시간에 따라 변하는 값을 처리할 수 있다.
     * @param args
     */
    public static void main(String[] args) {
        // 1. 값에 의미를 부여한다.
        System.out.println("보너스를 포함한 급여는 " + 1000000 + 10000 + "원 입니다.");
        int salary = 1000000;
        double bonus = salary * 0.01;
        System.out.println("보너스를 포함한 급여는 " + salary + bonus + "원 입니다.");

        //2. 값을 재사용하다.
        System.out.println("1번 고객에게 " + 100 + "포인트를 지급합니다.");
        System.out.println("2번 고객에게 " + 100 + "포인트를 지급합니다.");
        System.out.println("3번 고객에게 " + 100 + "포인트를 지급합니다.");

        int point = 100;
        System.out.println("1번 고객에게 " + point + "포인트를 지급합니다.");
        System.out.println("2번 고객에게 " + point + "포인트를 지급합니다.");
        System.out.println("3번 고객에게 " + point + "포인트를 지급합니다.");

        //3. 시간에 따라 변하는 값을 처리할 수 있다.
        int price = 0;
        System.out.println("총액은 " + price + "원 입니다.");
        price += 10000;
        System.out.printf("총액은 " + price + "원 입니다.");
        price += 20000;
        System.out.printf("총액은 " + price + "원 입니다.");

    }
}
