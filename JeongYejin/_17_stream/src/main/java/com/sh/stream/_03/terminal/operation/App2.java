package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * <pre>
 * reduce 단말연산
 * - 모든 요소에 대해 연산을 실행하고, 결과값을 한개로 도출해 내는 단말연산
 * - 두가지 방법 (초기값, 초가값없이!)
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // Function 인데 T타입과 R타입이 같으면 Operator라고 칭함
        // 1. 초기값(identity), BinaryOperator -> 초기값과 동일한 타입을 반환
        int result = IntStream.rangeClosed(1, 100)
                .reduce(0, (sum, n) -> {
                    System.out.println(sum + ", " + n);
                    return sum + n; // 시작값을 주고 거기에 차곡차곡 더해라~
                });
//        System.out.println(result);

        // 2. BinaryOperator
        Optional<Person> oldestPersont = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55)
        ).stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2 ); //객체를 계속 돌려주면 최종적으로 남아있는 것은 나이가 가장 많은 Person
        System.out.println(oldestPersont.get());

        // 이웃들의 평균나이를 출력
        double avgAge = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55)
        ).stream()
                .mapToInt(Person::getAge)
                // 스트림은 여기까지
                .average()
                // 단말연산
                .getAsDouble();
        System.out.println(avgAge);

    }
}