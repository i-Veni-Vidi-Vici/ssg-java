package com.sh.api._02.string;


import java.util.Arrays;

/**
 * <pre>
 * Escape문자
 * - 문자열 내부에서 특수문자를 표현하는 방식
 * - \문자 조합
 *
 * - \n 개행문자
 * - \t 탭문자
 * - \" 쌍따옴표
 * - \' 홀따옴표
 * - \\ 역슬래쉬
 *
 * </pre>
 *
 */
public class App4 {
    public static void main(String[] args) {
        System.out.println("개행문자 : a\nb"); // 맥/리눅스/유닉스
        System.out.println("개행문자 : a\r\nb"); //  윈도우 유일 \r 캐리지리턴 \n 라인피드

        System.out.println("탭문자 : a\tb");
        System.out.println("홑따옴표 : 저는 '홍길동'입니다.");
        System.out.println('\''); // 문자의 시작과 끝이 아니라 문자 그대로 홑따옴표 의미
//        System.out.println("쌍따옴표 : 저는 "홍길동"입니다."); // 두번째 나오는 쌍따옴표는 문자열의 끝이라고 생각해서 컴파일 오류
        System.out.println("쌍따옴표 : 저는 \"홍길동\"입니다."); // 문자열의 시작/끝이 아니라 문자 그대로 쌍따옴표 의미

        System.out.println("C:\\Workspaces\\java_workspace");
        System.out.println("C:\\Workspaces\\java_workspace");
        //문자열 안에서 붙여넣기 하면 자동 이스케이핑처리된다.

        String data = "abc$def$xyz"; // $가 구분자인 csv 데이터
        String[] arr = data.split("\\$"); // $는 끝을 의미하는 정규표현식 와일드카드 // 역슬래시 두개
        // \$f를 전달하기 위해 \\로 작성해야 한다.

        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length); // length은 배열의 길이
    }
}
