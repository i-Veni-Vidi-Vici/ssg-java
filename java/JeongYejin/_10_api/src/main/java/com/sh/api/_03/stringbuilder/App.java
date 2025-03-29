package com.sh.api._03.stringbuilder;

/**
 * <pre>
 * String
 * - 불변객체
 * - 문자열에 +연산을 하는 경우, 기존 문자열을 수정하지 않고, 새 문자열을 생성해서 반환한다
 * - 문자열 더하기 연산이 많은 경우, 성능이 떨어진다. (지금은 많이 개선)
 *
 * StringBuilder
 * - 가변객체
 * - 내부의 문자열값을 추가/수정/삭제가 가능하다. (문자열 값 저장소를 참조하지 않는다.)
 * - equals/hashCode 오버라이드 돼있지 않다. (객체기준으로 처리된다.)
 *
 * StringBuffer
 * - StringBuilder와 동일한 기능을 제공한다.
 * - 멀티쓰레드 환경에서 쓰레드간 동기화(쓰레드 접근 순서를 지정) 기능을 지원한다.
 * - 싱글쓰레드 환경에서는 StringBuilder가 성능이 우수하다.
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // String 더하기 연산 (기존에는 불필요한 문자열 공간이 낭비됨)
        // literal pool 동일한 값을 또 만들지 말자
        // jdk1.5 이후에는 문자열의 더하기 연산 StringBuilder를 이용해서 처리된다.
        String str = "";
        for (int i = 0; i < 26; i++) {
            str += (char)('a' + i);
            System.out.println(str);
        }
    // StringBuiler
        // append
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        System.out.println(sb.hashCode()); // 1746572565
        sb.append("b");
        System.out.println(sb.hashCode()); // 1746572565
        sb.append("c");
        System.out.println(sb.hashCode()); // 1746572565
        sb.append("defghi");
        System.out.println(sb.toString()); // abcdefghi

        // delete(start:int, end:int)
        sb.delete(2, 5);
        System.out.println(sb); // abfghi // 2~4번지 cde 제거됨
        sb.deleteCharAt(2);
        System.out.println(sb); // 2번지 f 제거

        // insert(offset:int, String)
        // - offset 시작인덱스(건너뛸 요소수)
        sb.insert(2, "xyz");
        System.out.println(sb); // abxyzghi

        // reverse(): StringBuilder 원본문자열 직접 변경
        sb.reverse();
        System.out.println(sb);
    }
}
