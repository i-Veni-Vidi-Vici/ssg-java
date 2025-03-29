package com.sh.lambda._02.anonymous.clazz;

/**
 * <pre>
 *
 *    ### 인터페이스를 구현하는 3가지 방법
 *  1. 직접 구현 클래스를 작성하고, 추상 메소드를 재작성하는 방식
 *  2. 익명 클래스 작성하고, 추상 메소드를 재작성하는 방식
 *  3. 람다식을 이용해서 추상 메소드를 간결히 작성하는 방식
 *
 *   - 람다식
 *     - 수학람다식을 프로그래밍에 적용한 케이스
 *     - f(x, y) = x * y  ⇒ (x, y) → x * y
 *
 *   - 문법
 *     - 구현할 인터페이스에 추상 메소드가 딱 하나만 존재해야 함
 *        - 자바에서 메소드는 단독으로 선언될 수 없다.
 *        - 람다식이 메소드 하나처럼 보여도, 무조건 객체 하나(인터페이스 구현체)이다.
 *        - @FuntionalInterface 유효성 검사 어노테이션 제공
 *     - 추상 메소드의 매개변수부를 화살표 좌측에, 메소드 구현부를 오른쪽 블럭에 작성
 *        - (int x, int y) → {…..}
 *     - 매개변수부의 자료형은 생략이 가능함
 *        - (x, y) → { return x * y; }
 *     - 우측 블럭이 리턴절 한줄인 경우, { }, return 키워드를 생략할 수 있다.
 *        - (x, y) →  x * y
 *     - 우측 블럭이 실행코드 한줄만 가진 경우, { }를 생략할 수 있다.
 *        - (k) → { System.out.prinln(k); }
 *        - (k) → System.out.prinln(k)
 *     - 매개변수가 하나 뿐인 경우, 소괄호 생략 가능
 *        - k → System.out.prinln(k)
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //인터페이스 - 구현 클래스 작성
        Calculator plusCalculator = new PlusCalculator();
        int result = plusCalculator.calc(10, 20);
        System.out.println(result);

        //익명 클래스 - 클래스 선언 + 객체 생성 동시에 처리
        //  - 인터페이스, 추상 클래스 앞에 new 연산자 + 몸통 작성(메소드 작성)
        Calculator minusCalculator = new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a - b;
            }
        };

        result = minusCalculator.calc(50, 25);
        System.out.println(result);

        //곱하기 계산기 객체 - 익명 클래스
        Calculator multiplyCalculator = new Calculator(){
            @Override
            public int calc(int a, int b) {
                return a * b;
            }
        };
        //람다식을 활용해서 나누기 계산기 객체 만들기
        Calculator divideCalculator = (int a, int b) -> {
            return a / b;
        };
//        Calculator divideCalculator = (a, b) -> a / b;
        result = divideCalculator.calc(10, 2);
        System.out.println(result);

        //다음 람다식을 사용하려며면 인터페이스
        Printer printer = (str) -> System.out.println(str); //String -> void
        printer.print("안녕");

        Func.IntFunc square = (n) -> n * n; // (int) -> int
        System.out.println(square.calc(10)); // 100

        Func.IntFunc square3 = (n) -> n * n * n;
        System.out.println(square3.calc(10)); //1000

        Func.DoubleFunc square2 = (n) -> n * n;
        System.out.println(square2.calc(0.5)); //0.25
    }


}
