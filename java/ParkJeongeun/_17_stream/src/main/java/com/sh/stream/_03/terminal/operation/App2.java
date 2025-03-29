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
        // 1. 초기값(identity), BinaryOperator -> 초기값과 동일한 타입을 반환
        int result = IntStream.rangeClosed(1, 100)
                .reduce(0, (sum, n) -> {
                    System.out.println(sum + ", " + n);
                    return sum + n;
                });
        System.out.println(result);

        // 2. BinaryOperator
        Optional<Person> oldestPerson = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55)
        ).stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);
        System.out.println(oldestPerson.get());

        // 이웃들의 평균나이를 출력
        double avgAge = Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("신사임당", 40),
                        new Person("이순신", 27),
                        new Person("장영실", 55)
                ).stream()
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println(avgAge);
    }
}
