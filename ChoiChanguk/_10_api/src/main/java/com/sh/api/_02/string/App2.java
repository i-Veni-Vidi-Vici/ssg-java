package com.sh.api._02.string;

import java.util.Scanner;
import java.util.SimpleTimeZone;

public class App2 {
    public static void main(String[] args) {
        //charAt(int) : char 특정인덱스 문자반환
        String str="apple";
        for (int i=0;i< str.length();i++) {
            System.out.println("charAt("+i+")"+str.charAt(i));
        }
        System.out.println();
        Scanner sc=new Scanner(System.in);


        //compareTo(String) : //문자열을 비교한 결과값을 정수로 반환
        //- 정렬사용시 내부적으로 호출됨
        // 0은 같은 경우, 음수 문자열이 작은 경우 = 사전에서 앞에 나온다
        // 양수 = 문자열이 크다, 사전에서 뒤에 나온다
        String txt1 = "java";
        String txt2 = "java";
        String txt3 = "JAVA";
        String txt4 = "ssg";

        System.out.println("compare to : " +txt1.compareTo(txt2));
        System.out.println("compare to : " +txt2.compareTo(txt3));
        System.out.println("compare to : " +txt3.compareTo(txt2));
        System.out.println("compare to : " +txt4.compareTo(txt4));
        System.out.println("compareToIgnores : "+txt1.compareToIgnoreCase(txt3));

        //concat(String):String //무자열을 연결연산 이후 새 문자열 반환
        System.out.println("concat : " +txt1.concat(txt4));
        System.out.println("txt1 = "+txt1+ "  txt2 = "+txt2);


        //indexOf(char):int
        //indexOf(String):int // 대상문자열에서 검색한 문자열의 인덱스를 반환(없으면 -1)
        String helloworld="helloworld";
        System.out.println("indexOf : "+helloworld.indexOf("z"));
        System.out.println("indexOf : "+helloworld.indexOf("w"));
        System.out.println("indexOf : "+helloworld.indexOf("o"));
        System.out.println("lastIndexOf : "+helloworld.lastIndexOf('r'));

        //contains(String):boolean
        System.out.println("contains : "+helloworld.contains("ll"));

        //trim():string 앞뒤의 공백을 제거 합니다. 새 문자열을 반환
        String tmp="     asdfadsf d    adsfasdf    ";
        System.out.println(tmp.trim());
        System.out.println(tmp);

        //to tolowerCase():String
        //to upCase():String
        String big="ASDQWE";
        String small="qwewer";
        System.out.println(big.toLowerCase());
        System.out.println(small.toUpperCase());

//        char choce=sc.next().charAt(0);
//        System.out.println(choce=='y');

        //subString(start : int , end):String) //start 인덱스부터 end인덱스전까지 문자열을 잘라서 반환
        String abc="asdfawefas";
        System.out.println("substring : "+abc.substring(2,4));
        System.out.println("substring : "+abc.substring(2));//end가 없는 경우 스타트부터 쭉 나열한다
        System.out.println(abc);

        //replace(target, replacement):string 문자열의 target부분을 replacement로 변경
        String word="i hate you";
        System.out.println("replace : "+word.replace("hate","love"));

        //isEmpty():boolean 문자열의 길이 0인가(null,""과는 다르다)
        System.out.println(word.isEmpty());
        System.out.println("".isEmpty());

        //isblank() : boolean 공백문자열인가? ("","   ", 모두공백이다)// 유효 문자가 있는가
        System.out.println("isBlack : "+"".isBlank());
        System.out.println("isBlack : "+"ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ".isBlank());

        String userInput =sc.nextLine();
        if(userInput.isBlank())
        {
            System.out.println("유효한 문자열을 입력해주세요");
        }

        //ㅁ
    }


}
