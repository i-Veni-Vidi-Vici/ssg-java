package com.sh.api._02.string;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        //charAt(int):char 특정 인덱스 문자 반환
        Scanner sc = new Scanner(System.in);
        String str = "apple";
        for(int i = 0; i<str.length(); i++){
            System.out.println("charAt("+i + ") : " + str.charAt(i));
        }
        System.out.println();

        //compareTo(String) : 문자열을 비교한 결과값을 정수로 변환
        // - 0 : 같은 경우
        // - 음수 : 문자열이 작은 경우 (사전에서 앞에 나오는 경우)
        // - 양수 : 문자열이 큰 경우 (사전에서 뒤에 나오는 경우)
        String txt1 = "java";
        String txt2 = "java";
        String txt3 = "JAVA";
        String txt4 = "ssg";
        System.out.println("compareTo : " + txt1.compareTo(txt2));  //0
        System.out.println("compareTo : " + txt2.compareTo(txt3));  //32
        System.out.println("compareTo : " + txt3.compareTo(txt2));  //-32
        System.out.println("compareTo : " + txt2.compareTo(txt4));  //-9
        //A~Z : 65 ~ 90
        //a~z : 97 ~ 122
        System.out.println("compareToIgnoreCase : " + txt1.compareToIgnoreCase(txt3));  //0

        //concat(String):String 문자열 연결 연산 이후 새 문자열 반환
        System.out.println("concat : " + txt1.concat(txt2));
        System.out.println("txt1 = " + txt1+" , txt2 = " +txt2);

        //indexOf(char):int
        //indexOf(String):int   //대상 문자열에서 검색한 문자열의 인덱스를 반환 (없으면 -1반환)
        String helloworld = "helloworld";
        System.out.println("indexOf : " + helloworld.indexOf('w')); //5
        System.out.println("indexOf : " + helloworld.indexOf('z')); //-1
        System.out.println("indexOf : " + helloworld.indexOf("low")); //3
        System.out.println("lastindexOf : " + helloworld.indexOf('o')); //6

        //trim():String 앞 뒤의 공백을 제거하고 새 문자열 반환
        String space = "      ㅋㅋㅋㅋ       ";
        System.out.println("trim : |"+ space.trim() + "|");
        System.out.println("trim : |"+ space + "|");

        //toLowerCase():String
        //toUpperCase():String
        String subject = "Java";
        System.out.println("toLowerCase : " + subject.toLowerCase());
        System.out.println("toUpperCase : " + subject.toUpperCase());
        //대소문자 구분없이 입력을 받아 판단하는 코드 작성시 유용

        //substring (start:int, end:int):String start 인덱스 전까지 문자열을 잘라서 반환
        String abc ="abcdefg";
        System.out.println("substring : " + abc.substring(2,5));    //cde
        System.out.println("substring : " + abc.substring(2));    //cdefg
        System.out.println("substring : " + abc.substring(2,abc.length()));    //cdefg
        System.out.println("abc = " + abc);

        //replace(target, replacement):String 문자열의 target부분을 replacement로 변경한 새 문자열로 대체
        String word = "I hate you";
        System.out.println("replace : "+ word.replace("hate", "love"));
        System.out.println("word = "+   word);

        //isEmpty():boolean 문자열의 길이가 0인가? (""과 null은 다르다)
        System.out.println("isEmpty : "+ "".isEmpty()); //true
        System.out.println("isEmpty : "+ "abc".isEmpty()); //false
        System.out.println("isEmpty : "+ "      ".isEmpty()); //false

        //isBlack():boolean 공백 문자열인가? ("", " " 모두 공백문자열이다)
        System.out.println("isBlank : " + "".isBlank());    //true
        System.out.println("isBlank : " + "   ".isBlank()); //true
        System.out.println("isBlank : " + "zzzzz".isBlank());//false

        System.out.println("문자열 입력");
        String userInput = sc.nextLine();
        if (userInput.isBlank()) {
            System.out.println("> 유효한 문자열을 입력하세요");
        }

        //contains(String):boolean
        System.out.println("contains : "+ helloworld.contains("hell"));
        System.out.println("contains : "+ helloworld.contains("ㅋㅋㅋ"));
        System.out.println("indexOf -> boolean : "+ (helloworld.indexOf("hell") > -1));
        System.out.println("indexOf -> boolean : "+ (helloworld.indexOf("ㅋㅋㅋ") > -1));
        System.out.println();


    }
}
