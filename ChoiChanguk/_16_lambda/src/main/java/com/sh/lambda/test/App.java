package com.sh.lambda.test;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.nio.channels.FileLock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {
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
     * 실습문제
     * 현재시각 HH:mm:ss.SSS을 출력하는 람다식을 작성
     * </pre>
     */
    private void test1() {
        Runnable runnable = () -> System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
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
        Supplier<Set<Integer>> supplier=()->{
            Set<Integer> set=new HashSet<>();
            set.add((int)(Math.random()*45) + 1);
            set.add((int)(Math.random()*45) + 1);
            set.add((int)(Math.random()*45) + 1);
            set.add((int)(Math.random()*45) + 1);
            set.add((int)(Math.random()*45) + 1);
            set.add((int)(Math.random()*45) + 1);
            System.out.println(set);
            return set;
        };
        supplier.get();
    }

    /**
     * @실습문제
     * 원화 입력시 환율 계산을 통해 얻어진 달러를 출력하는 람다식을 작성
     * 현재 1달러는 1350원이다.
     */
    private void test3() {
        System.out.printf("test3 : 2000원의 달러 환률을??\n");
        Consumer<Integer> consumer=(won)-> System.out.printf("%.1f달러입니다\n",won*1.1350);
        consumer.accept(2000);
    }

    /**
     * <pre>
     * @실습문제
     * 위 문제를 jdk가 제공하는 Function 함수형인터페이스 형식에 맞게 변형하세요.
     * </pre>
     */
    private void test4() {
        System.out.printf("test4 : 2000원의 달러 환률을??\n");
        Function<Integer,Float>function=(won)->{
            return (float) (won*1.1350);
        };
        System.out.printf(function.apply(2000)+"달러입니다\n");
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
        //람다식 만들어 놓고
        Predicate<String > predicate=(String s)->{
            return s.isBlank();
        };

        //그 람다식을 사용한다
        for(String str:strList)
        {
            System.out.println("str = "+str+" : " +predicate.test(str));
        }
    }
}
