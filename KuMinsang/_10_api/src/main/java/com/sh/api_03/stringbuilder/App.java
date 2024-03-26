package com.sh.api_03.stringbuilder;

/**
 * <pre>
 *     String
 *     - 불변객체
 *     - 문자열에 +연산을 하는 경우, 기존문자열을 수정하지 않고, 새 문자열을 생성해서 반환
 *     - 문자열 더하기 연산이 많은 경우, 성능이 떨어질수 밖에 없다
 *
 *     StringBuilder
 *     - 가변객체
 *     - 내부의 문자열 값을 추가/ 수정/ 삭제가 가능하다.(문자열 값 저장소를 참조하지 않는다)
 *     - equals/hashCode 오버라이드 되어있지 않다. 객체기준으로 처리된다.
 *
 *     StringBuffer
 *     - StringBuilder와 동일한 기능을 제공한다.
 *     - 멀티쓰레드 환경에서 쓰레드간 동기화 기능을 제공한다
 *     - 싱글쓰레드 환경에서는 StringBuilder의 성능이 우수하다
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //String 더하기 연산
        //jdk1.5이후에는 문자열의 더하기연산 StringBuilder를 이용해서 처맇된다
        String str = "";
        for(int i =0; i<26; i++){
            str+= (char)('a'+i);
            System.out.println(str);
        }   //비효율, 서로 다른 문자열 26개를 생성

        //StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        System.out.println(sb.hashCode());//989110044
        sb.append("b");
        System.out.println(sb.hashCode());//989110044
        sb.append("c");
        System.out.println(sb.hashCode());  //989110044
        sb.append("defghi");
        System.out.println(sb);

        sb.delete(2, 5);
        System.out.println(sb); //abfghi 2번지부터 4번지까지 삭제. endIndex인 5번은 포함되지 않음
        sb.deleteCharAt(2);
        System.out.println(sb); //f삭제 abghi

        //insert(offset:int, String)
        sb.insert(2, "xyz");
        System.out.println(sb); //abxyzghi [2]자리에 xyz를 삽입

        //reverse():StringBuilder 원본 문자열 직접 변경
        sb.reverse();
        System.out.println(sb);
    }
}
