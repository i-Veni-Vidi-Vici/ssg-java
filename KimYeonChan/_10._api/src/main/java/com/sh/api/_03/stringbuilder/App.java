package com.sh.api._03.stringbuilder;

/**
 * String
 * - 불변객체
 * - 문자열에 + 연사나을 하는 경우, 기존 문자열을 수정하지 않고, 새문자열을 생성에서 반환한다.
 * - 문자열 더하기 연산이 많은 경우, 성능이 떨어진다.
 * StringBuilder
 * - 가변객체
 * - 내부의 문자열 값을 추가/수정/삭제가 가능하다. (문자열 값 저장소를 참조하지 않는다.)
 * - equals/hashCode 오버라이드 되있지 않다. (객체 기준으로 처리된다.)
 * StringBuffer
 * - StringBuilder 와 동일한 기능을 제공한다.
 * - 멀티쓰레드 환경에서 쓰레드간 동기화 기능을 제공한다.
 * - 싱글쓰레드 환경에서는 StringBuilder 가 성능이 우수하다.
 */
public class App {
    public static void main(String[] args) {
        // String 더하기 연산
        // jdk1.5 이후에는 문자열의 더하기 연산 StringBuilder 를 이용해서 처리된다.
//        String str = "";
//        for (int i = 0; i < 26; i++) {
//            str += (char)('a' + i);
//            System.out.println(str);
//        }
        // StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        System.out.println(sb.hashCode());
        sb.append("b");
        System.out.println(sb.hashCode());
        sb.append("c");
        System.out.println(sb.hashCode());
        System.out.println(sb);

        // delete(start:int, end:int)
        sb.append("defxyz");
        sb.delete(2, 5);
        System.out.println(sb);
        sb.deleteCharAt(2);
        System.out.println(sb);

        // insert(offset:int, String)
        sb.insert(2, "xyz");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);
    }
}
