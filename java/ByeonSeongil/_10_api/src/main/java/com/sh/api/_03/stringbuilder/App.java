package com.sh.api._03.stringbuilder;

/**
 * <pre>
 * String
 * - 불변 객체
 * - 문자열에 + 연산을 하는 경우, 기존문자열을 수정하지 않고, 새문자열을 생성에서 반환
 * - 문자열 더하기 연산이 많은 경우, 성능이 떨어짐
 *
 * StringBuilder
 * - 가변객체
 * - 내부의 문자열값을 추가/수정/삭제가 가능함. (문자열 값 저장소를 참조하지 않음)
 * - equals/hashCode 오버라이드 되있지 않음 (객체기준으로 처리됨)
 *
 * StringBuffer
 * - StringBuilder와 동일한 기능제공
 * - 멀티쓰레드 환경에서쓰레드간 동기화(쓰레드 접근 순서를 지정) 기능을 지원
 * - 싱글스레드 환경에서는 StringBuilder가 성능이 우수함
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // String 더하기 연산
        // jdk1.5 이후에는 문자열의 더하기연산 StringBuilder를 이용해서 처리
        String str = "";
        for (int i = 0; i < 26; i++) {
            str += (char)('a' + i);
            System.out.println(str);
        }
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        System.out.println(sb.hashCode());
        sb.append("b");
        System.out.println(sb.hashCode());
        sb.append("c");
        System.out.println(sb.hashCode());
        System.out.println(sb.toString());
        sb.append("defgg");


        // delete(start:int, end:int)
        sb.delete(2, 5);
        System.out.println(sb); // 2~4번까지 삭제
        sb.deleteCharAt(2);
        System.out.println(sb);

        // insert(offset:int, String)
        // offset 시작 인덱스(건너뛸 요소수)
        sb.insert(0, "xyz");
        System.out.println(sb);

        // reverse(): StringBuilder 원본문자열 직접 변경
        sb.reverse();
        System.out.println();

    }
}
