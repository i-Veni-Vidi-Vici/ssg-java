package com.sh.api._02.string;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // charAt(int) : char 특정인덱스 문자반환
        String str = "apple";
        for (int i = 0; i < str.length(); i++) {
            System.out.println("charAt(" + i + ") : " + str.charAt(i));
        }
        System.out.println();

        // compareTo (String) : 문자열을 비교한 결과값을 정수로 반환, 정렬 사용시 내부적으로 호출됨
        // 0 : 같은 경우
        // 음수 : 문자열이 작은 경우 (사전에서 앞에 나오는 경우)
        // 양수 : 문자열이 큰 경우 (사전에서 뒤에 나오는 경우)
        String txt1 = "java"; // 소문자 a~z 97~122
        String txt2 = "java";
        String txt3 = "JAVA"; // 대문자 A~Z 65~90
        String txt4 = "ssg";
        System.out.println(txt1.compareTo(txt2)); // 0
        System.out.println(txt2.compareTo(txt3)); // 32
        System.out.println(txt3.compareTo(txt2)); // -32
        System.out.println(txt2.compareTo(txt4)); // -9
        System.out.println(txt1.compareToIgnoreCase(txt3)); // 0
        System.out.println();

        // concat(String) : String 문자열 연결 연산 이후 새 문자열 반환
        System.out.println(txt1.concat(txt2)); //javajava
        System.out.println(txt1 + txt2); //javajava (원본 문자열은 영향 받지 않음)
        System.out.println();

        // indexOf(int) : int
        // indexOf(String) : int 대상문자열에서 검색한 문자열의 인덱스 반환 (없으면 -1 반환)
        String helloworld = "helloworld";
        System.out.println(helloworld.indexOf('w')); // 5
        System.out.println(helloworld.indexOf('z')); // -1
        System.out.println(helloworld.indexOf("low")); // 3
        // 뒤에서부터 처음 발견되는 문자의 인덱스 반환 (인덱스는 앞에서부터 명명)
        System.out.println(helloworld.lastIndexOf('o')); // 6
        System.out.println();

        // contains(String):boolean
        System.out.println(helloworld.contains("hell")); // true
        System.out.println((helloworld.indexOf("hell") > -1)); // true
        System.out.println();

        // trim(): String 앞뒤의 공백 제거하고 새문자열 반환
        String space = "               ㅋㅋㅋ         ";
        System.out.println(space.trim());
        System.out.println(space); // 원본 영향 받지 않음
        System.out.println();

        // toLowerCase() : String
        // toUpperCase() : String
        String subject = "Java";
        System.out.println(subject.toLowerCase()); // java
        System.out.println(subject.toUpperCase()); // JAVA

//        System.out.print("맞습니까? (Y/N) : ");
//        char choice = sc.next().toLowerCase().charAt(0);
//        System.out.println(choice == 'y'); // y든 Y든 true 반환
//        System.out.println();

        // substring (start:int, end:int):String start 인덱스부터 end 인덱스 전까지 문자열을 잘라서 반환 (end인덱스 포함X)
        String abc = "abcdefg";
        System.out.println(abc.substring(2, 5)); // cde
        System.out.println(abc.substring(2)); // cdefg
        System.out.println(abc.substring(2, abc.length())); // cdefg
        System.out.println();

        // replace(target, replacement):String 문자열의 target부분을 replacement로 변경한 새 문자열 반환
        String word  = "I hate you";
        System.out.println(word.replace("hate", "love"));

        // isEmpty():boolean 문자열의 길이 0인가? 0이면 true (※ 0과 null은 다름)
        System.out.println("".isEmpty()); // true
        System.out.println("     ".isEmpty()); // false
        System.out.println();

        // isBlank():boolean 공백문자열인가? ("", "  " 모두 공백문자열 - true)
        System.out.println("".isBlank()); // true
        System.out.println("    ".isBlank()); // true
        System.out.println("ㅋㅋ".isBlank()); // false

//        System.out.print("> 문자열 입력 : ");
//        String userInput = sc.nextLine();
//        if (userInput.isBlank()){
//            System.out.println("> 유효한 문자열을 입력해주세요.");
//        }

        System.out.println();
    }
}
