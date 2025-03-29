package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * <pre>
 * reduce 단말연산
 * - 모든요소에 대해 연산을 실행하고, 결과값을 1개로 도출해 내는 단말연산
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
       int result =  IntStream.rangeClosed(1, 100)
                .reduce(0, (sum, n) -> {
                    System.out.println(sum + ", " + n);
                  return  sum + n;
                });
        System.out.println(result);

        Optional<Person> oldestPerson = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장열실", 55)
        ).stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);
        System.out.println(oldestPerson.get());

        // 이웃들의 평균 나이를 출력하세요
        // 스트림 만들고 mapTo 인트 중간 그다음 단말연산
        double avgAge = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장열실", 55)
        ).stream().mapToInt((p) -> p.getAge()) // 이 스트림은 이 숫자만 가지는 스트림이 될것임
                .average()
                .getAsDouble();
        System.out.println(avgAge);
    }
}
