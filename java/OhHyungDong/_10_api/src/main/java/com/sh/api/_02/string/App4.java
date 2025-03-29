package com.sh.api._02.string;

import java.util.Arrays;

/**
 * <pre>
 *  Escape 문자
 *  - 문자열 내부에서 특수 문자를 표현하는 방식
 *  - \문자 조합
 *  - \n : 개행문자
 *  - \t : 탭문자
 *  - \" : 쌍따옴표
 *  - \' : 홑따옴표
 *  - \\ : 역슬래쉬
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        System.out.println("개행문자 : a\nb");
        System.out.println("개행문자 : a\r\nb"); // \r 캐리지리턴

        System.out.println('\''); // ' : 문자의 시작과 끝이 아니라 문자 그대로 홑따옴표 의미

        System.out.println("쌍따움표 : 저는 \"홍길동\"입니다."); // " 문자열의 시작/끝이 아니라 문자 그대로 쌍따옴표 의미함.

        String data = "abc$def$xyz"; // $가 구분자인 csv데이터
        String[] arr = data.split("\\$"); // $는 끝을 의미하는 정규표현식 와일드 카드
        // \$를 전달하기 위해 \\로 작성해야 한다 .
        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);
    }
}
