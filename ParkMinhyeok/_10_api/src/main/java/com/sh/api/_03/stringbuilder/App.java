package com.sh.api._03.stringbuilder;

public class App {
    public static void main(String[] args) {
        // String 더하기 연산
        // jdk1.5 이후에는 문자열의 더하기 연산은 StringBuilder 를 이용해서 처리된다.
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
        System.out.println(sb);

        // delete(start:int, end:int)
        sb.delete(2, 5);
    }
}
