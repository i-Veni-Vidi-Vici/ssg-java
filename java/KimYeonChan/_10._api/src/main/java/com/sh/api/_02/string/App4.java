package com.sh.api._02.string;

import java.util.Arrays;

/**
 * Escape 문자
 * - 문자열 내부에서 특수문자를 표현하는 방식
 * - \문자 조합
 * - \n 개행문자
 * - \t tap
 * - \" 쌍따옴표
 * - \' 홑따옴표
 * - \\
 */
public class App4 {
    public static void main(String[] args) {
        System.out.println("개행문자: a\nb"); // 맥/리눅스/유닉스
        System.out.println("개행문자: a\r\nb"); // 윈도우 \r 캐리지리턴 \n 라인피드

        System.out.println("탭문자: a\tb");

        System.out.println("홑타옴표: 저는 '홍길동'입니다.");
        System.out.println('\''); // 문자의 시작과 끝이 아니라 문자 그대로 홑따옴표 의미

        System.out.println("쌍따옴표: a\"a\"a");

        System.out.println("C:\\Workspace\\java_workspace"); // 문자열 안에서 붙여넣기 하면 자동 이스케이프 된다.

        String data = "abc$def$xyz";
        String[] arr = data.split("\\$"); // $는 끝을 의미하는 정규식 와일드카드
        System.out.println(Arrays.toString(arr));
    }
}
