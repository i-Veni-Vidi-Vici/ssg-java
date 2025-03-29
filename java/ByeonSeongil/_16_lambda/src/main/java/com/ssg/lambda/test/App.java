package com.ssg.lambda.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.test1();
        Set<Integer> lotto = app.test2();
        System.out.println(lotto);
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
        Runnable runnable = () -> System.out.println(
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));

        runnable.run();
    }

    /**
     * <pre>
     * @실습문제2
     * 로또를 생성하는 람다식을 작성하세요.
     * - 리턴타입 Set<Integer>
     * </pre>
     */
    private Set<Integer> test2() {
        Supplier<Set<Integer>> supplier = () -> {
            Set<Integer> lotto = new HashSet<>();
            while (lotto.size() < 6) {
                lotto.add((int) (Math.random() * 45 + 1));
            }
            return lotto;
        };

        return supplier.get();

    }

    /**
     * <pre>
     * @실습문제3
     * 원화 입력시 환율 계산을 통해 얻어진 달러를 출력하는 람다식을 작성
     * 현재 1달러는 1350원이다.
     * </pre>
     */
    private void test3() {
        Scanner sc = new Scanner(System.in);
        Consumer<Integer> consumer = (won) ->
                System.out.println((double) won / 1350);

        System.out.print("원 입력 :");
        consumer.accept(sc.nextInt());
    }

    /**
     * <pre>
     * @실습문제4
     * 위 문제를 jdk가 제공하는 Function 함수형인터페이스 형식에 맞게 변형하세요.
     * </pre>
     */
    private void test4() {
        Scanner sc = new Scanner(System.in);

        Function<Integer, Double> function = (won) ->
                (double) won / 1350;

        System.out.print("원 입력 :");
        System.out.println(function.apply(sc.nextInt()));
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
        Function<List<String>, List<Boolean>> function = (list) ->
                list.stream().map((str) -> !str.isBlank()).collect(Collectors.toList());

        System.out.println(function.apply(strList));
    }
}