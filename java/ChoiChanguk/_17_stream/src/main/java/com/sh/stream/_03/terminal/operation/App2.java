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
        //1. 초기값(identity), BinaryOperator-> 초기값과 동일한 타입을 반환해줍니다
        int result=IntStream.rangeClosed(1,100)
                //아래 뜻은 int sum=50; 여기부터 1~100을 더한다고 생각하면 된다
                .reduce(50,(sum,b)-> {
                    System.out.println(sum + ", " + b);
                    return sum+b;
                });

        //reduce(0,(sum,b)->sum+b);
        //이건 0~b까지 sum+=b라는 뜻이다
        System.out.println(result);


        Optional<Person> oldPerson=Arrays.asList(
                new Person("홍길동",33),
                new Person("신사임당",40),
                new Person("이순신",27),
                new Person("장영실",55)
                ).stream()
                .reduce((p1,p2)->p1.getAge()>p2.getAge()?p1:p2);

        System.out.println(oldPerson.toString());

        // 이웃들의 평균 나이를 출력
        double avg=Arrays.asList
                (
                        new Person("홍길동",33),
                        new Person("신사임당",40),
                        new Person("이순신",27),
                        new Person("장영실",55)
        )
                .stream()
                .mapToInt(Person::getAge)// 중간연산
                .average()// 단말연산. 여기까지 스트림의 연산
                .getAsDouble();// 여기는 Optional의 연산
        System.out.println(avg);

    }
}
