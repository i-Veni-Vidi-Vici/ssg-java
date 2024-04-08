package com.sh.stream._02.intermediate.operation;

import java.util.List;
import java.util.stream.Stream;

/**
 * <pre>
 * map 중계연산
 * - 주어진 Function람다식에 따라 요소를 변환
 * - 변환된 결과에 따라서 Stream타입이 변경될 수 있다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .map((n)->n*10)
                .forEach(System.out::println);

        //이 경우, map n*10 출력
        // valueOf한거 출력이 나온다
        //즉 10~50 나오고 그걸 또 10한걸 문자로 바꿔서 출력
        // 100~500 문자로 출력
        List.of(1, 2, 3, 4, 5)
                .stream()
                .map((n)->n*10)
                .map((n)->String.valueOf(n*10))
                .forEach(System.out::println);

        // 이름 중에 성만 가지고 오고싶다
        Stream.of("홍길동","신사임당","이순신","강감찬")
                .map((name)->name.charAt(0))
                .forEach(System.out::println);

        // 데이터의 공백을 제거 후 출력
        //replace(a,b) = 변수에서 a=타겟, b= 타겟을 바꾼다
        //여기서는 replace(a,b)= (타겟=공백,타겟을 없앤다)
        //이건 스트링배열로 해서 해보자
        Stream.of("a b c d","Hello World","너의 이름은 신사임당!!    ")
                .map((name)->name.replace(" ",""))
                .forEach(System.out::println);

        // 숫자가 아닌 데이터 제거
        // 숫자만 찾는 정규식 = "[0-9]"
        // 문자만 찾는 정규식 = "[^0-9]" ^=캐럿 = 반전이 된다
        // map(~) 이건 하나의 조건식이다 아래보면 map이 3인데
        // map조건 후, 그 전에 있던 map조건 후 , 그 전에 있던 map조건 -> printf해준다
        // ```````````이건 스트링배열로 받아서 스트림으로 바꾸고 해보자
        Stream.of("1,000,000", "$500","4달라","500원만 주세요")
                .map((str)->str.replaceAll("[^0-9]",""))
                //.map((n)->Integer.parseInt(n))
                .mapToInt((n)->Integer.parseInt(n))
                .map((n)->n+123)
                .forEach(System.out::println);
    }
}
