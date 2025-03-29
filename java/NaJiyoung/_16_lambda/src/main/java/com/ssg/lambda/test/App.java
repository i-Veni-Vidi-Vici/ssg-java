package com.ssg.lambda.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        app.test1();
        app.test2();
        app.test3();
        app.test4();
        app.test5();
    }

    /**
     * <pre>
     * @실습문제1
     * 현재시각 HH:mm:ss.SSS을 출력하는 람다식을 작성
     * </pre>
     */
    private void test1() {
        Runnable runnable = () -> System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss.SSS")));
        runnable.run();
    }

    /**
     * <pre>
     * @실습문제2
     * 로또를 생성하는 람다식을 작성하세요.
     * - 리턴타입 Set<Integer>
     * </pre>
     */
    private void test2() {
        Set<Integer> set = new TreeSet<>();
        while (set.size() < 6)
            set.add((int) (Math.random() * 45 + 1));

        Supplier<Set<Integer>> lotto = () -> set;
        System.out.println("lotto = " + lotto.get());
    }

    /**
     * <pre>
     * @실습문제3
     * 원화 입력시 환율 계산을 통해 얻어진 달러를 출력하는 람다식을 작성
     * 현재 1달러는 1350원이다.
     * </pre>
     */
    private void test3() {
        System.out.print("원화 입력 : ");
        Consumer<Double> calc = (won) -> System.out.println(Math.round(won / 1350.0 * 1000) / 1000.0 + "달러");
        calc.accept(sc.nextDouble());
    }

    /**
     * <pre>
     * @실습문제4
     * 위 문제를 jdk가 제공하는 Function 함수형인터페이스 형식에 맞게 변형하세요.
     * </pre>
     */
    private void test4() {
        System.out.print("원화 입력 : ");
        Function<Integer, Double> calc = (won) -> Math.round(won / 1350.0 * 1000) / 1000.0;
        double dollar = calc.apply(sc.nextInt());
        System.out.println(dollar + "달러");
    }

    /**
     * <pre>
     * @실습문제5
     * 공백을 제외한 문자열의 길이가 0인지를 체크하는 람다식을 만들고,
     * 문자열리스트 {"abc","","대한민국","   "}를 체크하세요.
     * </pre>
     */
    private void test5() {
        List<String> strList = Arrays.asList("abc", "", "대한민국", "   ");
        Predicate<String> isLen0 = (str) -> str.trim().isEmpty();
        for(String str : strList)
            System.out.println("[" + str + "]의 길이는 0입니까? : " + isLen0.test(str));
    }
}