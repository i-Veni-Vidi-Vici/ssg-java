package com.ssg.oop.method._static;

import java.util.Arrays;

public class StaticMethod {
    //static method
    //1. 전달한 문자열을 모두 대문자로 바꾸는 static 메소드
    //메소드명 : toUpper(String) : String
    public static String toUpper(String str) {
        str = str.toUpperCase();
        System.out.println(str);
        return str;
    }

    //2. 문자열(1)에서 전달받은 인덱스(2)의 문자를 전달받은 문자(3)로 변경하는 static 메소드
    //메소드명 : setChar(String, int, char) : String
    public static String setChar(String str, int num, char chr) {
        char[] strs = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strs[i] = str.charAt(i);
        }
        strs[num] = chr;
        System.out.println(Arrays.toString(strs));
        return str;
    }


    //3. 전달한 문자열에서 영문자의 개수를 리턴하는 static 메소드
    //메소드명 : getAlphabetLength(String) : int
    public static int getAlphabetLength(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }


    //4. 전달한 문자열값을 하나로 합쳐서 리턴
    //메소드명 : concat(String, String) : String
    public static String concat(String str1, String str2){
        String strs = str1+str2;
        System.out.println(strs);
        return strs;
    }

}
