package com.sh.api_02.string;

import java.util.Arrays;

/**
 * <pre>
 *     Escape문자
 *     - 문자열 내부에서 특수문자를 표현하는 방식
 *     - \문자 조합으로 이루어져 있음
 *     - \n 개행문자
 *     - \t 탭문자
 *     - \" 쌍따옴표
 *     - \' 홑따옴표
 *     - \\ 역슬래시
 *
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        System.out.println("개행문자 : a\nb");
        System.out.println("개행문자 : a\r\nb");    //\r 윈도우에서만 적용 \r캐리지리턴 \n라인피드

        System.out.println("탭문자 : a\tb");
        System.out.println("홑따옴표 : 저는 '홍길동'입니다. ");
        System.out.println('\'');   //문자의 시작과 끝이 아니라 문자 그대로의 홑따옴표 의미
        //쌍따옴표
        System.out.println("쌍따옴표: 저는 \"홍길동\" 입니다.");

        System.out.println("C:\\Workspace\\java_workspace");

        String data = "abc$def$xyz";    //$달러가 구분자인 csv데이터
        String[] arr = data.split("$");
        System.out.println(Arrays.toString(arr));
        //달러는 구분자로 작동하지 않음. $는 끝을 의미하는 정규표현식 와일드카드


    }
}
