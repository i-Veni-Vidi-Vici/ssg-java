package com.sh.variable;

public class VariableApp {
    /**
     * <h3>변수</h3>
     * <pre>
     *     - 메모리 상의 값을 보관하기 위한 공간
     * </pre>
     * <h3>변수의 사용 목적</h3>
     * <pre>
     *     1. 값을 변수에 담아 사용하기 위한 목적을 표현
     *     2. 값을 재사용할 수 있다.
     *     3. 시간에 따라 변하는 값을 처리할 수 있다.
     * </pre>
     * @param args
     */
    public static void main(String[] args){
        //1. 값에 의미를 부여한다.
        int salary = 1000000;
        double bonus = salary * 0.01;
        System.out.println("보너스를 포함한 급여는 " + (salary+bonus) + "원 입니다.");
        System.out.println();

        //2. 값을 재사용 할 수 있다.
        int point = 100;
        System.out.println("1번 고객에게 " + point + "포인트를 지급합니다.");
        System.out.println("2번 고객에게 " + point + "포인트를 지급합니다.");
        System.out.println("3번 고객에게 " + point + "포인트를 지급합니다.");
        System.out.println();

        //3. 시간에 따라 변하는 값을 처리할 수 있다.
        int price = 0;
        System.out.println("총액은 " + price + "원 입니다.");
        // '=' 대입연산자 - 우항의 값을 좌항의 공간에 대입. 연산자 우선순위가 낮다.
        price = price + 10000;
        System.out.println("총액은 " + price + "원 입니다.");
        price = price + 20000;
        System.out.println("총액은 " + price + "원 입니다.");
        System.out.println();

    }
}
