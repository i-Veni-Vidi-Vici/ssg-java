package com.ssg.oop.method._static;


/**
 * 기능제공 클래스
 *
 */

public class StaticMethod {
    //static method
    //1. 전달한 문자열을 모두 대문자로 바꾸는 static 메소드
    //메소드명 : toUpper(String) : String
    public static String toUpper(String str){
        str = str.toUpperCase();
        System.out.println(str);
        return str;
    }

    //2. 문자열(1)에서 전달받은 인덱스(2)의 문자를 전달받은 문자(3)로 변경하는 static 메소드
    //메소드명 : setChar(String, int, char) : String
    public static String setChar(String str, int n, char m ){
        char[] arr = new char[str.length()]; // 전달받은 문자열 길이 만큼 배열 생성
        for (int i = 0; i < str.length(); i++) {
            if (i != n) {
                arr[i] += str.charAt(i); // 배열에 각 인덱스마다 값 넣어주기 각 문자라서 char사용
            }else {
                arr[i] += m; // m은 원래 char
            }
        }
        String result = new String(arr); // 값 출력 위해 생성자
        System.out.println(result);
        return result;
    }


    //3. 전달한 문자열에서 영문자의 개수를 리턴하는 static 메소드
    //메소드명 : getAlphabetLength(String) : int

    public static int getAlphabetLength(String str){
        int count = 0; // 초기화
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                count++; // 영문자 일때마다 세기
            }
        }
        System.out.println(count);
        return count;

    }


    //4. 전달한 문자열값을 하나로 합쳐서 리턴
    //메소드명 : concat(String, String) : String
    public String concat(String str1, String str2){
        String strs = str1 + str2;
        System.out.println(strs);
        return strs;
    }

}
