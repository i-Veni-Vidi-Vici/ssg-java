package com.sh.api._03.stringbuilder;

/**
 * <pre>
 * String
 * - 불변객체
 * - 문자열에 +연산 하는 경우, 기존 문자열을 수정하지 않고, 새문자열을 생성해서 반환
 * - 문자열 더하기 연산이 많은 경우, 성능이 떨어짐
 *
 * StringBuilder
 * - 가변객체
 * - 내부의 문자열값을 추가/수정/삭제가 가능 (문자열 값 저장소(String Literal Pool)를 참조하지 않음)
 * - equals/hashCode 오버라이드 되어있지 않음 (객체기준으로 처리됨)
 *
 * StringBuffer
 * - StringBuilder와 동일한 기능을 제공함
 * - 멀티쓰레드 환경에서 쓰레드 간 동기화 기능(쓰레드의 접근 순서를 지정) 제공
 * - 싱글쓰레드 환경에서는 StringBuilder가 성능이 우수
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // String 더하기 연산
        // jdk1.5 이후에는 문자열의 더하기 연산은 StringBuilder를 이용해서 처리됨
//        String str = "";
//        for (int i = 0; i < 26; i++) {
//            str += (char)('a' + i);
//            System.out.println(str);
//        }

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("a"); // a
        System.out.println(sb.hashCode()); // 918221580
        sb.append("b"); // ab
        System.out.println(sb.hashCode()); // 918221580
        sb.append("c"); // abc
        System.out.println(sb.hashCode()); // 918221580
        sb.append("defghi");
        System.out.println(sb.toString()); // abcdefghi

        // delete(start:int, end:int) : 마지막 인덱스 포함X
        sb.delete(2, 5);
        System.out.println(sb); // abfghi
        sb.deleteCharAt(2);
        System.out.println(sb); // abghi

        // insert(offset:int, String)
        // - offset 시작인덱스(건너띌 요소수)
        sb.insert(2,"xyz"); // 2번째 인덱스 자리부터 채워넣음
        System.out.println(sb); // abxyzghi

        // reverse(): StringBuilder 원본문자열 직접 변경
        sb.reverse();
        System.out.println(sb); // ihgzyxba
    }
}
