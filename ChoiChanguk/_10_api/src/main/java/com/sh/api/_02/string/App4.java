package com.sh.api._02.string;

/***
 * <pre>
 * Escape문자
 * - 문자열 내부에서 특수문자를 표현
 * - \문자 조합
 *
 * \n 개행문자
 * \t 탭문자
 * \" 쌍따옴표
 * \' 홀따옴표
 * \\
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        System.out.println("가나다라\n마바사");
        System.out.println("개행문자 : a\r\nb");// 윈도우만 가능, \n,\r
        System.out.println("탭문자 : ㅁㄴㅇ\tㄻㄴㅇㄹ");
        System.out.println("홀따옴표 : 저는 '홍길동' 입니다");
        System.out.println("홀따 : \'");// 문자의 시작과 끝이 아니라 문자 그대로 홀따옴표 의미
        System.out.println("쌍따옴표 : 저는 \"홍길동\"입니다");
        System.out.println("경로를 쓸때 역슬래시역슬래시 : C:\\Workspaces\\java_workspace");
        System.out.println("\"C:\\workspaces\\java_workspace\"");

        String data="abc$def$xyz";
        String[] arr=data.split("\\$");// $는 끝을 의미하는 정규표현식 와일드카드
        // \$를 전달하기 위해 \\로 작성해야 한다
        System.out.println(data);
    }

}
