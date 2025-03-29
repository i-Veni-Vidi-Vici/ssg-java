package com.sh.api._03.stringbuilder;

/**
 * <pre>
 *     String
 *     - 불변객체
 *     - 문자열에 + 연산을 하는 경우, 기존 문자열을 수정하지 않고 새 문자열을 생성하여 리턴
 *     - 문자열 + 연산이 많은 경우, 성능이 떨어진다. // 옛날 얘기
 *
 *     StringBuilder
 *     - 가변 객체
 *     - 내부의 문자열 값을 추가 / 수정 / 삭제가 가능하다. (문자열 값 저장소 String Literal Pool을 참조하지 않는다.)
 *     - equals/hashCode 메소드가 오버라이드 되어 있지 않다. ( 객체 기준으로 처리된다.)
 *
 *     StringBuffer
 *     - StringBuilder와 동일한 기능을 제공한다.
 *     - 멀티스레드 환경에서 쓰레드 간 동기화(쓰레드 접근 순서를 지정) 기능을 지원한다.
 *     - 싱글스레드 환경에서는 StringBuilder가 성능이 우수하다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        // String 더하기 연산
//        // jdk 1.5 이후에는 문자열의 더하기 연산은 StringBuilder를 이용해서 처리된다.
//        String str = "";
//        for(int i = 0; i < 26; i++) {
//            str += (char) ('a' + i);
//            System.out.println(str);
//        }

        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("a");                         // "a"
        System.out.println(sb.hashCode());      // 918221580
        sb.append("b");                         // "ab"
        System.out.println(sb.hashCode());      // 918221580
        sb.append("c");                         // "abc"
        System.out.println(sb.hashCode());      // 918221580
        sb.append("defghi");                    // "abc"
        System.out.println(sb.toString());      // "abcdefghi"

        // delete(start:int, end:int)
        sb.delete(2, 5);                        // 2~4번지까지 삭제
        System.out.println(sb);                 // abfghi
        sb.deleteCharAt(2);               // 2번지에 있는 f 삭제
        System.out.println(sb);                 // abghi

        // insert(offset:int, String)
        // offset은 시작 인덱스 또는 건너 뛸 요소의 개수를 의미
        sb.insert(2, "xyz");
        System.out.println(sb);

        // reverse():StringBuilder 원본 문자열 직접 변경
        sb.reverse();
        System.out.println(sb);
    }
}
