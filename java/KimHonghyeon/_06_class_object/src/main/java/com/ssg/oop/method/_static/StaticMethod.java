package com.ssg.oop.method._static;

public class StaticMethod {

    //static method
    //1. 전달한 문자열을 모두 대문자로 바꾸는 static 메소드
    //메소드명 : toUpper(String) : String
    public static String uoUpper(String str){
        return str.toUpperCase();
    }


    //2. 문자열(1)에서 전달받은 인덱스(2)의 문자를 전달받은 문자(3)로 변경하는 static 메소드
    //메소드명 : setChar(String, int, char) : String
    public static String setChar(String str, int idx, char replaceChar){
        char[] strCharArr = str.toCharArray();
        strCharArr[idx] = replaceChar;
        return new String(strCharArr);
    }


    //3. 전달한 문자열에서 영문자의 개수를 리턴하는 static 메소드
    //메소드명 : getAlphabetLength(String) : int
    public static int getAlphabetLength(String str){
        int count=0;
        for(int i =0; i<str.length(); i++){
            char c  = str.charAt(i);
            if((c>='A'&&c<='Z')||(c>='a'&&c<='z'))count++;
        }
        return count;
    }

    //4. 전달한 문자열값을 하나로 합쳐서 리턴
    //메소드명 : concat(String, String) : String
    public static String concat(String strA, String strB){
        return strA.concat(strB);
    }
}
