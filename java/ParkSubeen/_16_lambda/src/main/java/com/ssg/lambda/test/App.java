package com.ssg.lambda.test;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        App app = new App();
//        app.test1();
//        app.test2();
//        app.test3();
//        app.test4();
        app.test5();
    }

    /**
     * <pre>
     * @실습문제
     * 현재시각 HH:mm:ss.SSS을 출력하는 람다식을 작성
     * </pre>
     */
    private void test1() {
        Runnable now = () -> System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        now.run();
    }

    /**
     * <pre>
     * @실습문제2
     * 로또를 생성하는 람다식을 작성하세요.
     * - 리턴타입 Set<Integer>
     * </pre>
     */
    private void test2() {
        Supplier<Set<Integer>> lotto = () -> {
            Random rnd = new Random();
            Set<Integer> set = new TreeSet<>();
            while(set.size() < 6)
                set.add(rnd.nextInt(45) + 1);
            return set;
        };
        System.out.println(lotto.get());
    }

    /**
     * @실습문제
     * 원화 입력시 환율 계산을 통해 얻어진 달러를 출력하는 람다식을 작성
     * 현재 1달러는 1350원이다.
     */
    private void test3() {
        Consumer<Integer> calc = (won) -> {
            double rate = 1350;
            double dollar = won / rate;
            System.out.println("원화 : " + won + " => 달러 :" + dollar);
        };
        calc.accept(3000);
    }

    /**
     * <pre>
     * @실습문제
     * 위 문제를 jdk가 제공하는 Function 함수형인터페이스 형식에 맞게 변형하세요.
     * </pre>
     */
    private void test4() {
        Function<Integer, Double> calc = (won) -> {
            double rate = 1350;
            return won / rate;
        };
        System.out.println(calc.apply(3000));
    }

    /**
     * <pre>
     * @실습문제
     * 공백을 제외한 문자열의 길이가 0인지를 체크하는 람다식을 만들고,
     * 문자열리스트 {"abc","","대한민국","   "}를 체크하세요.
     * </pre>
     */
    private void test5() {
        List<String> strList = Arrays.asList("abc", "", "대한민국", "   ");
        Predicate<String> check = (str) -> str.trim().length() == 0;
        for(String str : strList) {
            System.out.println(str + "의 길이는 0인가? " + check.test(str));
        }
    }
}
