package com.sh.api._03.stringbuilder;

/**
 * String
 * -불변객체
 * -문자열에 +연산을 하는 경우, 기존문자열을 수정하지 않고, 새문자열을 생성에서 반환한다.
 * -문자열 더하기 연산이 많은 경우, 성능이 떨어진다.
 *  StringBuilder
 *  -가변객체
 *  -내부의 문자열값을 추가/수정/삭제가 가능하다.(문자열 값 저장소를 참조하지 않는다.)
 *  -equals/hashCode 오버라이드 되있지 않다.(객체기준으로 처리된다.)
 *
 *
 *
 *
 * StringBuffer
 * -StringBuilder와 동일한 기능을 제공한다.
 * -멀티쓰레드 환경에서 쓰레드간 동기화 기능을 제공한다.
 */
public class App {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        System.out.println(sb.toString());
        sb.append("defghi");
        System.out.println(sb);
        sb.delete(2,5); //2~4 삭제
        System.out.println(sb);
        sb.deleteCharAt(2);
        System.out.println(sb);
        //insert
        sb.insert(2,"xyz");
        System.out.println(sb);
    }
}
