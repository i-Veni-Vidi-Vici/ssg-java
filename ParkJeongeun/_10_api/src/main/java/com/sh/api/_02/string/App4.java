package com.sh.api._02.string;

import java.util.Arrays;

/**
 * <pre>
 * Escape문자
 * - 문자열 내부에서 특수문자를 표현하는 방식(\문자 조합)
 * -
 * - \n 개행문자
 * - \t 탭문자
 * - \" 쌍따옴표
 * - \' 홑따옴표
 * - \\ 역슬래시
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        System.out.println("개행문자 : a\nb"); // 맥, 리눅스, 유닉스
        System.out.println("개행문자 : a\r\nb"); // 윈도우에서만 가능 \r 캐리지리턴 \n 라인피드
        System.out.println("탭문자 : a\tb");
        System.out.println('\'');
        System.out.println("쌍따옴표 : \"홍길동\"");
        System.out.println("C:\\Workspaces\\java_workspace");
        System.out.println("\"C:\\Workspaces\\java_workspace\""); // 경로 복사해서 문자열 안에 붙여넣기 하면 자동 이스케이핑 처리됨

        String data = "abc$def$xyz"; // $가 구분자인 csv데이터
//        String[] arr = data.split("$"); // $는 "끝"을 의미하는 정규표현식 와일드카드
//        System.out.println(Arrays.toString(arr)); // [abc$def$xyz]
        String[] arr = data.split("\\$"); // \$를 전달하기 위해 \\로 작성해야함
        System.out.println(Arrays.toString(arr)); // [abc, def, xyz]
    }
}
