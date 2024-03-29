package com.sh.api._02.string;

// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        // charAt(int):char 특정인덱스 문자반환

        Scanner sc= new Scanner(System.in);
        String str = "apple"; // 0 1 2 3 4
        for (int i = 0; i < str.length(); i++) {
            System.out.println("charAt(" + i  + ") : " + str.charAt(i));
        }
        System.out.println();
        
        // compareTo(String) : 문자열을 비교한 결과값을 정수로 반환
        // 정렬사용시 내부적으로 호출.
        // - 0 : 같은 경우
        // - 음수 : 문자열이 작은경우 (사전에서 앞에 나오는 경우)
        // - 양수 : 문자열이 큰경우 (사전에서 뒤에 나오는 경우)

        String txt1 = "java";
        String txt2 = "java";
        String txt3 = "JAVA";
        String txt4 = "ssg";
        System.out.println("compareTo : " + txt1.compareTo(txt2)); // 0
        System.out.println("compareTo : " + txt2.compareTo(txt3)); // 32
        System.out.println("compareTo : " + txt2.compareTo(txt2)); // -32
        System.out.println("compareTo : " + txt2.compareTo(txt4)); // -9
        System.out.println("compareToIgnoreCase : " + txt2.compareTo(txt3)); // -9

        //concat(String):String 문자열 연결연산이후 새 문자열 반환
        System.out.println("concat : " + txt1.concat(txt2)); // javajava
        System.out.println("txt = " + txt1 + ", txt2 = " + txt2);
        System.out.println();

        //indexOf(int): int
        //indexOf(String):int 대상문자열에서 검색 문자열의 인덱스 반환(없으면 -1를 반환)
        String helloworld = "helloworld";
        System.out.println("indexOf : " + helloworld.indexOf('w')); // 5 // 문자도 가능
//        System.out.println("indexOf : " + helloworld.indexOf("w")); // 5
        System.out.println("indexOf : " + helloworld.indexOf('z')); // 업서 -1
        System.out.println("indexOf : " + helloworld.indexOf("low")); // 업서 -1 //문자열도 가능
        System.out.println("lastIndexOf : " + helloworld.lastIndexOf('o')); // 6 뒤에서 부터 찾는다는거지 인덱스는 앞에서부터 센다.

        //contains(String):boolean
        System.out.println("contains : " + helloworld.contains("hell"));
        System.out.println("contains : " + helloworld.contains("ㅋㅋㅋ"));
        System.out.println("indexOf -> boolean : " + (helloworld.indexOf("hell") > -1));
        System.out.println("indexOf -> boolean : " + (helloworld.indexOf("ㅋㅋㅋ") > -1));
        System.out.println();




        //trim() : String 앞뒤의 공백 제거하고 새문자열 반환 스트림
        String space = "                  ㅋㅋㅋㅋㅋㅋㅋㅋㅋ             ";
        System.out.println("trim : |" + space.trim() + "|"); // 공백 날라감
        System.out.println("space : |" + space + "|"); // 원본 그대로

        //toLowerCase():String
        //toUpperCase():String

        String subject = "Java";
        System.out.println("toLowerCase : " + subject.toLowerCase()); // 소문자
        System.out.println("toUpperCase : " + subject.toUpperCase()); // 대문자
        System.out.println("맞습니까? Y/N : ");
//        char choice = sc.next().toLowerCase().charAt(0);
//        System.out.println(choice == 'y');

        System.out.println();

        //substring(start:int, end:int) : String start 인덱스부터 end인덱스전까지 문자열으 잘라서 반환
        String abc = "abcdfg";
        System.out.println("substring : " + abc.substring(2,5)); // 시작인덱스 포함 엔드인덱스 포함x 2~부터 4
        System.out.println("substring : " + abc.substring((2))); //
        System.out.println("substring : " + abc.substring(2,abc.length())); // 시작인덱스 포함 엔드인덱스 포함x\
        System.out.println("abc = " + abc);
        System.out.println();

        //replace(target, replacement):String 문자열의 target부분을 replacement로 변경한 새 문자열
        String word = "I hate you~";
        System.out.println("replace : " + word.replace("hate","love"));
        System.out.println("word =" + word);

        // isEmpty():boolean 문자열의 길이 0인가? (""과 null과 다르다) 정말 길이가 빵인가?
        System.out.println("isEmpty : " + "".isEmpty()); // true
        System.out.println("isEmpty : " + "abc".isEmpty()); // false
        System.out.println("isEmpty : " + "         ".isEmpty()); // false
        System.out.println();

        //isBlank():boolean  공백문자열인가? ( "", "   " 모두 공백문자열이다)
        System.out.println("isBlank :" + "".isBlank()); // true
        System.out.println("isBlank :" + "        ".isBlank()); //true
        System.out.println("isBlack : " + "ㅋㅋㅋㅋㅋㅋ".isBlank()); // false

        System.out.println("문자열 입력 : ");
        String userInput = sc.nextLine();
        if(userInput.isBlank()){
            System.out.println("> 유효한 문자열을 입력해주세요...");
        }




    }
}
