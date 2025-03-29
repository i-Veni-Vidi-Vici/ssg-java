package com.ssg.lamda.test;


import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        App app = new App();
        //app.test1();
       // app.test2();
       // app.test3();
       // app.test4();
        app.test5();
    }

    /**
     * <pre>
     * @실습문제1
     * 현재시각 HH:mm:ss.SSS을 출력하는 람다식을 작성
     * </pre>
     */
    private void test1() {
        Consumer<LocalDateTime> consumer = s -> System.out.println(s);
        System.out.println("현재시각 ");
        consumer.accept(LocalDateTime.now());
    }

    /**
     * <pre>
     * @실습문제2
     * 로또를 생성하는 람다식을 작성하세요.
     * - 리턴타입 Set<Integer>
     * </pre>
     */
    private void test2() {
        Set<Integer> lotto = new HashSet<>();
        while(lotto.size() <6)
        {
            Random rnd = new Random();
            int num = rnd.nextInt(45) + 1;
            lotto.add(num);
        }
        lotto.forEach(num -> System.out.print(num + " "));
    }

    /**
     * <pre>
     * @실습문제3
     * 원화 입력시 환율 계산을 통해 얻어진 달러를 출력하는 람다식을 작성
     * 현재 1달러는 1350원이다.
     * </pre>
     */
    private void test3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("원화를 입력하세요 : ");
        long won = scanner.nextLong();
        Function<Long,Long> function =  n -> (n / 1350) ;
        System.out.print("달러 출력 : $" + function.apply(won));

    }

    /**
     * <pre>
     * @실습문제4
     * 위 문제를 jdk가 제공하는 Function 함수형인터페이스 형식에 맞게 변형하세요.
     * </pre>
     */
    private void test4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("원화를 입력하세요 : ");
        long won = scanner.nextLong();
        Function<Long,Long> function =  n -> (n / 1350) ;
        System.out.print("달러 출력 : $" + function.apply(won));

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
        Predicate<String> predicate = s -> s.length() == 0;
        for (int i = 0; i < strList.size(); i++) {
            String str = strList.get(i);
            System.out.println(i + "번째 문자 : " + predicate.test(str));
        }

    }
}
