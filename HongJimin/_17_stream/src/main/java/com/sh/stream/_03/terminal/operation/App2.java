package com.sh.stream._03.terminal.operation;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * <pre>
 *     reduce 단말 연산 - 딱 값 하나만 출력하게 되는 메소드
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        int result = IntStream.rangeClosed(1, 100)
                .reduce(0, (sum, n) -> {
                    System.out.println(sum +  ", " + n);
                    return sum + n;
                });
        System.out.println(result); //5050

        Optional<Person> oldestPerson =  Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55)
        ).stream().reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2);
        System.out.println(oldestPerson.get()); //Person{name='장영실', age=55}

        //이웃들의 평균 나이를 출력
        double avgAge = Arrays.asList(
                new Person("홍길동", 33),
                new Person("신사임당", 40),
                new Person("이순신", 27),
                new Person("장영실", 55)
        ).stream()
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
        System.out.println(avgAge); //38.75
    }
}
