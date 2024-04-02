package com.sh.api._03.stringbuilder;

/**
 * <pre>
 * String
 * - 불변객체
 * - 문자열에 + 연산을 하는 경우, 기존 문자열을 수정하지 않고, 새 문자열을 생성해서 반환한다.
 * - 문자열 더하기 연산이 많은 경우, 성능이 떨어진다.


 * StringBuilder
 * - 가변객체
 * - 내부의 문자열값으 추가/수정/삭제가 가능하다.(문자열 값 저장소를 참조하지 않는다.)
 * - equals/hashCode가 오버라이드 되있지 않다. (객체기준으로 처리된다.)
 *
 *
 * StringBuilder
 * - StringBuilder와 동일한 기능을 제공한다.
 * - 멀티쓰레드 환경에서 쓰레드간 동기화(쓰레드 접근 순서를 지정)능을 지원한다.
 * - 싱글쓰레드 환경에서는 StringBuilder가 성능이 우수하다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //String 더하기 연산
        //jdk1.5 이후에는 문자열의 더하기연산 StringBuilder를 이용해서 처리된다.
//        String str = "";
//        for(int i = 0; i < 26; i ++){
//            str += (char)('a' + i);
//            System.out.println(str);
//        }
        StringBuilder sb = new StringBuilder();
        sb.append("a"); // "a"
        System.out.println(sb.hashCode());
        sb.append("b");
        System.out.println(sb.hashCode());
        sb.append("c");
        System.out.println(sb.hashCode());
        sb.append("defghi");
        System.out.println(sb.toString());

        //delete(start:int, end:int)
        sb.delete(2, 5);
        System.out.println(sb); // 2~4번지까지 삭제 abfghi
        sb.deleteCharAt(2);
        System.out.println(sb); //abghi

        //insert ( offset:int, String)
        sb.insert(2, "xyz");
        System.out.println(sb);

        //reverse() : StringBuilder 원본문자열 직접 변경
        sb.reverse();
        System.out.println(sb);
    }
}
