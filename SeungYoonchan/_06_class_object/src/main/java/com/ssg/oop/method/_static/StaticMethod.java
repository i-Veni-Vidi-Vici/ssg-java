package com.ssg.oop.method._static;

public class StaticMethod {
    //static method
    //1. 전달한 문자열을 모두 대문자로 바꾸는 static 메소드
    //메소드명 : toUpper(String) : String
    public static String toUpper(String str) {
        return str.toUpperCase();
    }

    //2. 문자열(1)에서 전달받은 인덱스(2)의 문자를 전달받은 문자(3)로 변경하는 static 메소드
    //메소드명 : setChar(String, int, char) : String
    public static String setChar(String str, int index, char ch) {
        if (index < 0 || index >= str.length())
            return str;
        char[] charArray = str.toCharArray();
        charArray[index] = ch;

        String temp = new String(charArray);

        return temp;
    }

    //3. 전달한 문자열에서 영문자의 개수를 리턴하는 static 메소드
    //메소드명 : getAlphabetLength(String) : int
    public static int getAlphabetLength(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                count++;
        }
        return count;
    }

    //4. 전달한 문자열값을 하나로 합쳐서 리턴
    //메소드명 : concat(String, String) : String
    public static String concat(String str1, String str2) {
        return str1.concat(str2);
    }
}