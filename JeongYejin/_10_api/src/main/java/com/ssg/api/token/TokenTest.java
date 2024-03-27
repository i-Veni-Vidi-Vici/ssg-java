package com.ssg.api.token;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String str = "J a v a P r o g r a m ";
        System.out.println("글자 : " + str + " 및 개수 : " + str.length());
        StringTokenizer st = new StringTokenizer(str, " ");
        System.out.println("토큰 처리후 문자배열 개수 : " + st.countTokens());
        char[] chars = new char[st.countTokens()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        System.out.print("char[] : ");
        String str2 = "";
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
            str2 += chars[i];
            if (i < chars.length -1){
                System.out.print(", ");
            }
        }
        System.out.println();
        System.out.println("String으로 변환 : " + str2);
        System.out.println("모두 대문자로 변환 : " + str2.toUpperCase());
    }
}
