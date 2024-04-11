package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * <pre>
 * reduce 단말연산
 * - 모든 요소에 대해 연산을 실행하고, 결과값을 1개로 도출해내는 단말연산
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        int result = IntStream.rangeClosed(1, 100)
                .reduce(0, (sum, n) -> {
                    System.out.println(sum + ", " + n);
                    return sum + n;
                });
        System.out.println(result);

        Optional<Person> optionalPerson = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55)
        ).stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);
        System.out.println(optionalPerson.get());

        // 이웃들의 평균 나이를 출력
        double avgAge = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55)
        ).stream()
            .mapToInt(Person::getAge) // 중간연산
            .average() // 단말연산
            .getAsDouble(); // optional의 메소드
        System.out.println(avgAge);
    }
}
