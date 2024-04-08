package com.ssg.lambda.test;

import java.time.LocalTime;
import java.util.*;
import java.util.function.*;

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
     * @실습문제
     * 현재시각 HH:mm:ss.SSS을 출력하는 람다식을 작성
     * </pre>
     */
    private void test1() {
        Runnable runnable = () -> {
            LocalTime localTime = LocalTime.now();
            long micro = localTime.getNano()/1000000L;
            System.out.println(localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond()+":"+micro);
        };
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
        Supplier<Set<Integer>> supplier = () -> {
            Set<Integer> set = new HashSet<>();
            while(set.size()<6){
                set.add((int)(Math.random()*45)+1);
            }
            return set;
        };
        System.out.println(supplier.get());
    }

    /**
     * @실습문제
     * 원화 입력시 환율 계산을 통해 얻어진 달러를 출력하는 람다식을 작성
     * 현재 1달러는 1350원이다.
     */
    private void test3() {
        IntConsumer consumer = (won) -> System.out.println(won/1350);
        Scanner sc = new Scanner(System.in);
//        System.out.print("원달러 변환기 입니다. \n 원화 :");
//        consumer.accept(sc.nextInt());
        consumer.accept(2700);
    }

    /**
     * <pre>
     * @실습문제
     * 위 문제를 jdk가 제공하는 Function 함수형인터페이스 형식에 맞게 변형하세요.
     * </pre>
     */
    private void test4() {
        Function<Long, Long> function = (won) -> won/1350;
        System.out.println(function.apply(4050L));
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
        Predicate<String> predicate = str -> {
            boolean tf= false;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) != ' '){
                    tf = true;
                }
            }
            return tf;
        };

        Iterator<String> iterator = strList.iterator();
        while(iterator.hasNext()) {
            String str = iterator.next();
            if(predicate.test(str)){
                System.out.println(str+"는 공백을 제외한 문자열의 길이가 0이 아닙니다");
            }else{
                System.out.println(str+"은 공백을 제외한 문자열의 길이가 0입니다");
            }
        }
    }
}

