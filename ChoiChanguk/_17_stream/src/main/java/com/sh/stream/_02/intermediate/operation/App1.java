package com.sh.stream._02.intermediate.operation;

import java.io.StringBufferInputStream;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

/**
 * <pre>
 * filter 중계연산
 * - Predicate 람다식의 반환값이 true인 요소만 남김
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        IntStream stream=IntStream.rangeClosed(1,10);
        //stream.forEach(System.out::print); 스트림은 1회용이기 때문이다
        stream.filter((n)->n%2==0).forEach(System.out::println);

        //이렇게도 쓴다 1회용인걸 굳이 한 번 더??
        IntStream.rangeClosed(1,10).
                filter((n)->n%2==0).forEach(System.out::println);

        //중복 제거
        IntStream.of(1,3,4,5,7,7,8,3,34,89)
                .distinct().forEach(System.out::println);

        //1. 이름이 동자로 끝나는 이름만 출력
        //2. 홍으로 시작, 동으로 끝남
        List<String > names=List.of("홍길동","고길동","신사임당","마동석");
        names.stream().
                filter((name)->name.endsWith("동")).
                filter((name)->name.startsWith("홍")).
                forEach(System.out::println);


    }
}
