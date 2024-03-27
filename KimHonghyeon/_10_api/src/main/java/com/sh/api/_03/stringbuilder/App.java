package com.sh.api._03.stringbuilder;

public class App {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("abc");
        sb.append(1234);
        System.out.println(sb);
        sb.delete(1,3);
        System.out.println(sb);
    }
}
