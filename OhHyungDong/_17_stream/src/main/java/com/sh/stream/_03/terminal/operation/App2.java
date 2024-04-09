package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 * <pre>
 *     reduce 단말 연산
 *     - 모든 요소에 대해 연산을 실행하고, 결과값을 1개로 도출해 내는 단말 연산
 *     - max, average 이런 집계함수들을 이용하지 않고 한번에 처리 해 줄 수 있는 연산
 *     .reduce(시작 초기값, (결과 초기값 , 스트림에 있는 값) -> 초기값 + 스트림에 있는 값
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        int reduce = IntStream.rangeClosed(1, 100)
                //reduce의 identity 버전을 사용하면 return값은 int
                .reduce(0, (sum, n) -> sum + n);
        System.out.println(reduce);

        Optional<Person> oldestPerson = Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("신사임당", 40),
                        new Person("이순신", 27),
                        new Person("장영실", 55)
                ).stream()
                // reduce에서 다른 버전을 사용하면 Optional 객체를 가진 값을 사용한다.
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);
        System.out.println(oldestPerson.get());

        //이웃들의 평균 나이를 출력하세요
        double age =  Arrays.asList(
                        new Person("홍길동", 33),
                        new Person("신사임당", 40),
                        new Person("이순신", 27),
                        new Person("장영실", 55))
                .stream()
                .mapToInt(Person::getAge).average().getAsDouble();


    }
}
