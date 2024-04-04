package com.sh.lambda._02.anonymous.clazz;
//인터페이스 - 구현클래스 작성


/**
 * <pre>
 *     인터페이스를 구현하는 3가지 방법
 *     1. 직접 구현 클래스를 작성하고, 추상 메소드를 재작성하는 방식
 *     2. 익명클래스를 작성하고, 추상메소드를 재작성하는 방식
 *     3. 람다식을 이용해서 추상메소드를 간결히 작성하는 방식
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        int result = 0;
        PlusCalculator plusCalculator = new PlusCalculator();
        result = plusCalculator.calc(10, 5);
        System.out.println(result);

        Calculator minusCalculator = new Calculator(){
            @Override
            public int calc (int a , int b){
                return a-b;
            }
        };
        result = minusCalculator.calc(50,25);
        System.out.println(result);

        //곱하기 계산기 객체 - 익명클래스

        Calculator multiplyCalculator = new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a * b;
            }
        };
        result = multiplyCalculator.calc(10, 2);
        System.out.println(result);

        //람다식의 활용해서 나누기 계산기 객체 만들기
        Calculator divideCalculator = (int a, int b) ->{
            return a / b;
        };
//        Calculator divideCalculator = (a, b) -> a / b;
        result = divideCalculator.calc(10, 2);
        System.out.println(result);
        //매개변수가 1개인 경우 ()생략 가능
        //코드가 한 줄인 경우 {} 생략 가능
        Printer printer = str -> System.out.println(str);
        printer.print("람다식");

        Printer printer2 = System.out::print;
        printer2.print("인스턴스 메소드 레퍼런스\n");

        Func.IntFunc square = (n) -> n * n;
        System.out.println(square.calc(10)); //100

        Func.DoubleFunc square2 = (n) -> n * n;
        System.out.println(square2.calc(0.5)); //0.25


    }
}
