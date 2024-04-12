package com.sh.lambda._02.annonymous;

import java.security.PrivateKey;

/**
 * 인터페이스를 구현하는 3가지 방법
 * 1. 직접 구현 클래스를 작성하고, 추상메소드를 재작성하는 방식
 * 2. 익명 클래스를 작성하고, 추상 메소드를 재작성하는 방식
 * 3. 람다식을 이용해서 추상메소드를 간결히 작성하는 방식
 *
 *
 * 람다식
 * - 수학 람다식을 프로그래밍에 적용한 케이스
 * - f(x,y) = x * y;->
 *          람다식 : (x,y) -> x* y
 *
 * 문법
 * 1. 구현할 인터페이스에 추상메소드가 딱 하나만 존재해야함. -> (구현해야 할 메소드가 하나뿐일 때 )
 *      - 자바에서 메소드는 단독으로 선언될 수 없다,.
 *      - 람다식이 메소드 하나처럼 보여도, 무조건 객체 하나(인터페이스 구현체)이다.
 *      - 인터페이스에 추상메소드가 하나만 존재하는지 확인하기 위해서 @FuctionalInterface 유효성 검사 어노테이션 제공
 * 2. 추상 메소드의 매개변수부를 화사라표 좌측에, 메소드 구현부를 오른쪽에 블럭에 작성
 *      (int x, int y) -> {...}
 * 3. 매개변수부의 자료형은 생략이 가능하다.
 *      (x,y) -> {return x *y;}
 * 4. 우측 블럭이 리턴절 한줄인 경우, {}, return 키워드를 생략할 수 있다.
 *      (x,y) -> x * y;
 * 5. 우측 블럭이 실행코드 한줄만 가진 경우 {}을 생략할 수 있다.
 *      (k) -> {System.out.printlnt(k);}
 *      (k) -> System.out.printlnt(k);
 * 6. 매개변수가 하나뿐인 경우, 소괄호 생략 가능
 *           k -> System.out.printlnt(k);
 *
 *
 */
public class App
{
    public static void main(String[] args) {

        //인터페ㅣ스 - 구현 클래스 작성
        Calculator plusCalculator = new PlusCalculator();
        int result = plusCalculator.calc(10, 20);
        System.out.println(result);

        //익명 클래스 - 클래스 선언 + 객체 생성 동시에 처리
        //- 인터페이스, 추상 클래스 앞에 new 연산자 + 몸통 작성(메소드 작성)
        Calculator minusCalculator = new Calculator() {
            @Override
            public int calc(int a, int b) {
                return  a - b;
            }
        };
        result = minusCalculator.calc(50, 25);
        System.out.println(result);


        Calculator multiCalculator = new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a * b;
            }
        };
        result = multiCalculator.calc(20, 10);
        System.out.println(result);

        //람다식을 활용해서 나누기 계산기 객체만들기
        Calculator divideCalCulator = (a,b) -> a/ b;
        result = divideCalCulator.calc(10, 2);
        System.out.println(result);

        //다음 람다식을 사용하려면...
        Printer printer = (str) -> System.out.println(str);
        printer.print ("안녕");

        Func.IntFunc square = (n) -> n * n; // n -> 매개변수 -> n * n (리턴값)
        System.out.println(square.calc(10));
    }
}
