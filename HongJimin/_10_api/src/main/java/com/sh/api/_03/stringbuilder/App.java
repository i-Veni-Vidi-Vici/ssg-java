package com.sh.api._03.stringbuilder;

/**
 * <pre>
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //String 더하기 연산
        //jdk 1.5이후에는 문자열의 더하기연산 StringBuilder를 이용해 처리됨
//        String str = "";
//        for (int i = 0; i < 26; i++) {
//            str += (char) ('a' + i);
//            System.out.println(str);
//        }

        //StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a");
        System.out.println(stringBuilder.hashCode());//918221580
        stringBuilder.append("b");
        System.out.println(stringBuilder.hashCode()); //918221580
        stringBuilder.append("c");
        System.out.println(stringBuilder.hashCode()); //918221580
        stringBuilder.append("defghi");
        System.out.println(stringBuilder);

        //delete(start : int, end : int)
        stringBuilder.delete(2, 5);
        System.out.println(stringBuilder); //2 ~ 4번지 삭제 abfghi
        stringBuilder.deleteCharAt(2);
        System.out.println(stringBuilder); // 2번지 삭제 abghi

        //insert(offset : int, String)
        //offset 시작 인덱스 (건너뛸 요소수)
        stringBuilder.insert(2, "xyz"); //2번째 인덱스부터 다음에 오는 string 을 끼워넣어 주세용
        System.out.println(stringBuilder); //abxyzghi

        //reverse() : StringBuilder 원본문자열 직접 변경
        stringBuilder.reverse();
        System.out.println(stringBuilder); //ihgzyxba
    }
}
