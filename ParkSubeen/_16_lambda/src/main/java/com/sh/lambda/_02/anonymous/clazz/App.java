package com.sh.lambda._02.anonymous.clazz;

/**
 * <pre>
 * 인터페이스를 구현하는 3가지 방법
 * 1. 직접 구현클래스를 작성하고, 추상메소드를 재작성하는 방식
 * 2. 익명클래스를 작성하고, 추상메소드를 재작성하는 방식
 * 3. 람다식을 이용해서 추상메소드를 간결히 작성하는 방식
 *
 * 람다식
 * - 수학람다식을 프로그래밍에 적용한 케이스
 * - f(x, y) = x * y => (x, y) -> x * y
 *
 * 문법
 * 1. 구현할 인터페이스에 추상메소드가 딱 하나만 존재해야 한다.
 *      - 자바에서 메소드는 단독으로 선언될 수 없다.
 *      - 람다식이 메소드하나처럼 보여도, 무조건 객체 하나(인터페이스 구현체)이다.
 *      - @FunctionalInterface 유효성검사 어노테이션 제공
 * 2. 추상메소드의 매개변수부를 화살표 좌측에, 메소드 구현부를 오른쪽 블럭에 작성
 *      (int x, int y) -> { .... }
 * 3. 매개변수부의 자료형은 생략이 가능하다.
 *      (x, y) -> { return x * y; }
 * 4. 우측블럭이 리턴절 한줄인 경우, {}, return키워드를 생략할 수 있다.
 *      (x, y) -> x * y
 * 5. 우측블럭이 실행코드 한줄만 가진 경우, {}을 생략할 수 있다.
 *      (k) -> { System.out.println(k); }
 *      (k) -> System.out.println(k)
 * 6. 매개변수가 하나뿐인 경우, 소괄호 생략가능
 *      k -> System.out.println(k)
 * </pre>
 */
public class App {
    public static void main(String[] args) {

        // 인터페이스 - 구현클래스 작성
        Calculator plusCalculator = new PlusCalculator();
        int result = plusCalculator.calc(10, 20);
        System.out.println(result); // 30

        // 익명클래스 - 클래스 선언 + 객체 생성 동시에 처리
        // - 인터페이스, 추상클래스 앞에 new 연산자 + 몸통 작성(메소드 작성)
        Calculator minusCalculator = new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a - b;
            }
        };
        result = minusCalculator.calc(50, 25);
        System.out.println(result); // 25

        // 곱하기 계산기객체 - 익명클래스
        Calculator multiplyCalculator = new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a * b;
            }
        };
        result = multiplyCalculator.calc(20, 3);
        System.out.println(result); // 60

        // 람다식을 활용해서 나누기계산기객체 만들기
        Calculator divideCalculator = (int a, int b) -> {
            return a / b;
        };
//        Calculator divideCalculator = (a, b) -> a / b;
        result = divideCalculator.calc(10, 2);
        System.out.println(result);

        // 다음 람다식을 사용하려면... 인터페이스
        Printer printer = (str) -> System.out.println(str + " " + str); // String -> void
        printer.print("안녕");

        Func.IntFunc square = (n) -> n * n;
        System.out.println(square.calc(10)); // 100

        Func.IntFunc square3 = (n) -> n * n * n;
        System.out.println(square3.calc(10)); // 1000

        Func.DoubleFunc square2 = (n) -> n * n;
        System.out.println(square2.calc(0.5)); // 0.25

    }
}
