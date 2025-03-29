package com.sh.stream._02.intermediate.operation;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * <pre>
 * peek 중간연산
 * - Consumer 람다를 통해 요소를 변경하지 않고, 특정처리가 가능하다
 *
 * 스트림 3단계
 * 1. 스트링 생성 - 중간연산 - 단말연산의 흐름이 만들어진 후 이요소를 하나씩 처리한다
 *  - 단말연산까지는 흐름이 만들어 지지 않으며, 스트림은 실행하지 않는다
 * 2. 스트림 중간 연산(0~)
 * 3. 스트림 단말연산연산 (1)
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,20)
                .peek((n)->{
                    System.out.println("[peek]"+n);
                })
                .filter((n)->n%2==0)
                .forEach(System.out::println);


        Stream.of("one","two","three")
                .peek((str)-> System.out.println(1+" "+str))
                .filter((str)-> str.length()>3)
                .peek((str)-> System.out.println(2+" "+str))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        /*
        * */
    }

}
