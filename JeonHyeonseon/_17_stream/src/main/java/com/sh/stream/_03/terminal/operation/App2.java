package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 * <pre>
 * reduce 단말연산
 *  - 모든 요소에 대해 연산을 실행하고, 결과값을 1개로 도출해내는 단말연산
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 1. 초기값(identity), BinaryOperator -> 초기값과 동일한 타입을 반환
        int result = IntStream.rangeClosed(1, 100)
                // n은 스트림의 요소이다.
                .reduce(0, (sum, n) -> { // int
                    System.out.println(sum + ", " + n);
                    return sum + n;  // int 반환
                });
        System.out.println(result);

        // 2. BinaryOperator
        Optional<Person> oldestPerson = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55)
        ).stream()
//                .reduce((p1, p2) -> 나이가 가장 많은 Person객체)
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);
        System.out.println(oldestPerson.get());

        // 이웃들의 평균나이를 출력해보기
        double avgAge = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55)
        ).stream()
                .mapToInt((p) -> p.getAge()) // ).stream().mapToInt(Person::getAge) 와 동일
                .average()
                .getAsDouble();
        System.out.println(avgAge);
    }
}
