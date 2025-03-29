package com.sh.api._03.stringbuilder;

/**
 * <pre>
 * String
 * - 불변객체
 * - 문자열에 +연산을 하는 경우, 기존문자열을 수정하지 않고, 새 문자열을 생성해서 반환
 * - 문자열 더하기 연산이 많은 경우, 성능이 떨어진다
 *
 * StringBuilder
 * - 가변객체
 * - 내부의 문자열값을 추가/수정/삭제가 가능하다 (문자열 값 저장소를 참조하지 않는다)
 * - equals/hashCode 오버라이드 되어 있지 않다. (객체기준으로 처리한다)
 *
 * StringBuffer
 * - StringBuilder와 동일한 기능을 제공한다.
 * - 멀티쓰레드 환경에서 쓰레드간 동기화(쓰레드 접근순서를 지정) 기능을 지원한다
 * - 싱글쓰레드 환경에서는 StringBuilder가 성능이 우수하다.
 *
 *
 * !!!!!! String Literal Pool  = 겹치는 애들을 굳이 또 만들지 말고 주소를 이어 붙이자
 * </pre>
 */

public class App {

    public static void main(String[] args) {
        //jdk1.5이후에는 문자열의 더하기 연산은 StringBuilder를 이용해서 처리된다.
//        //String 더하기 연산
//        String str="";
//        for (int i=0;i<26;i++) {
//            str+=(char)('a'+i);//a방 ab방, abc방 이렇게 계속 있다
//            System.out.println(str);
//        }

        //StringBuilder
        //같은 객체에 작업을 한다
        StringBuilder sb = new StringBuilder();
        sb.append("A");//A
        System.out.println(sb.hashCode());
        sb.append("B");//AB
        System.out.println(sb.hashCode());
        sb.append("C");//ABC
        System.out.println(sb.toString());
        sb.append("DEFGHI");//ABCEDFGHI

        //delete(start : int , end : int)
        sb.delete(2,5);
        System.out.println(sb);
        sb.deleteCharAt(2);
        System.out.println(sb);

        //insert(offset:int, string)
        //offset 시작인덱스(건너뛸 요소수)
        sb.insert(2,"xyz");
        System.out.println(sb);

        //reverse : StringBuilder 원본으로 작업한다
        sb.reverse();
        System.out.println(sb);

    }
}
