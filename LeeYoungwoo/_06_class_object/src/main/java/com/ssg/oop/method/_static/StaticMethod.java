package com.ssg.oop.method._static;


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
//        str.charAt(num) = chr;
        char[] charArr = new char[str.length()];
        for(int i = 0; i < str.length(); i++){
            charArr[i] = str.charAt(i);
        }
        charArr[num] = chr;
//        for(String s : charArr) {
//            System.out.print(s);
//        }
        System.out.print(charArr);
        return new String (charArr);
    }


    //3. 전달한 문자열에서 영문자의 개수를 리턴하는 static 메소드
    //메소드명 : getAlphabetLength(String) : int


    //4. 전달한 문자열값을 하나로 합쳐서 리턴
    //메소드명 : concat(String, String) : String


}
