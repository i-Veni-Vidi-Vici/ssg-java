package com.sh.api._02.string;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // charAt(int): char 특정인덱스 문자반환
        String str = "apple"; // 0 1 2 3 4
        for (int i = 0; i < str.length(); i++) {
            System.out.println("charAt(" + i + ") : " + str.charAt(i));
        }
        System.out.println();

        // compareTo(String) : 문자열을 비교한 결과값을 정수로 반환. 정렬사용시 내부적으로 호출.
        // - 0 : 같은 경우
        // - 음수 : 문자열이 작은 경우 (사전에서 앞에 나오는 경우)
        // - 양수 : 문자열이 큰 경우 (사전에서 뒤에 나오는 경우)
        // 숫자값은 중요하지 않고, (0인가, 0보다 작은가, 0보다 큰가)가 중요!
        String txt1 = "java";
        String txt2 = "java";
        String txt3 = "JAVA";
        String txt4 = "ssg";
        System.out.println("compareTo : " + txt1.compareTo(txt2)); // 0
        System.out.println("compareTo : " + txt2.compareTo(txt3)); // 32
        System.out.println("compareTo : " + txt3.compareTo(txt2)); // -32
        System.out.println("compareTo : " + txt2.compareTo(txt4)); // -9 j가 s보다 9개 더 앞서있다.
        System.out.println("compareToIgnoreCase : " + txt1.compareToIgnoreCase(txt3)); // 대소문자 구분 X // 0
        System.out.println("compareToIgnoreCase : " + txt1.compareToIgnoreCase(txt4)); // 대소문자 구분 X 숫자 의미 X // - 9
        System.out.println();

        // concat(String):String 문자열 연결연산이후 새 문자열 반환
        System.out.println("concat : " + txt1.concat(txt2)); // javajava
        System.out.println("txt1 = " + txt1 + ", txt2 = " + txt2); // 원본은 바뀌지 않음
        System.out.println();

        // indexOf(int) : int
        // indexOf(String) : int (overloading) 대상 문자열에서 검색한 문자열의 인덱스 반환 (없으면 -1 반환)
        String helloworld = "helloworld";
        System.out.println("indexOf : " + helloworld.indexOf('w')); // 5
        System.out.println("indexOf : " + helloworld.indexOf('l')); // 2
        System.out.println("indexOf : " + helloworld.indexOf('z')); // -1 // 인덱스가 없어서 음수이다
        System.out.println("indexOf : " + helloworld.indexOf("low")); // 3 // 문자열 찾기 가능
        System.out.println("lastIndexOf : " + helloworld.lastIndexOf('o')); // 뒤에서부터 찾기 (인덱스는 바뀌지 않음) // 6
        System.out.println();

        // contains(String) : boolean
        System.out.println("contains : " + helloworld.contains("hell")); // true
        System.out.println("contains : " + helloworld.contains("ㅋㅋㅋㅋ")); // false
        System.out.println("indexOf -> boolean : " + (helloworld.indexOf("hell") > -1)); // true
        System.out.println("indexOf -> boolean : " + (helloworld.indexOf("ㅋㅋㅋ") > -1)); // false // 인덱스가 없으면 음수이기 때문에
        System.out.println();

        // trim() : String 앞뒤의 공백을 제거하고 새 문자열을 반환
        String space = "                  ㅋㅋㅋㅋ           ";
        System.out.println("trim : |" + space.trim() + "|");
        System.out.println("space = |" + space + "|");

        // toLowerCase() : String
        // toUpperCase() : String
        String subject = "java";
        System.out.println("toLowerCase : " + subject.toLowerCase());
        System.out.println("toUpperCase : " + subject.toUpperCase());

//        char choice = sc.next().toLowerCase().charAt(0);
//        System.out.println(choice == 'y');

        System.out.println();

        // substring(start:int, end:int):String start 인덱스부터 end인덱스 '전'까지 문자열을 잘라서 반환
        String abc = "abcdefg";
        System.out.println("substring : " + abc.substring(2, 5)); // 2 3 4
        System.out.println("substring : " + abc.substring(2)); // cdefg
        System.out.println("substring : " + abc.substring(2, abc.length())); // cdefg
        System.out.println("abc = " + abc);

        // replace(target, replacement):String 문자열의 target부분을 replacement로 변경한 새 문자열을 반환
        String word = "I hate you~";
        System.out.println("replace : " + word.replace("hate", "love"));
        System.out.println("word = " + word);
        System.out.println();

        // isEmpty():boolean 문자열의 길이 0인가? (""과 null은 다르다)
        System.out.println("isEmpty : " + "".isEmpty()); // true
        System.out.println("isEmpty : " + "abc".isEmpty()); // false
        System.out.println("isEmpty : " + "         ".isEmpty()); // false
        String nullString;
//        System.out.println("isEmpty : " + nullString.isEmpty()); // 초기화되지 않은 null String은 컴파일 오류!
        System.out.println();

        // isBlank(): boolean 공백문자열인가? ("", "   " 모두 공백문자열이다)
        System.out.println("isBlank : " + "".isBlank()); // true
        System.out.println("isBlank : " + "         ".isBlank()); // true
        System.out.println("isBlank : " + "ㅋㅋㅋㅋㅋ".isBlank()); // false

        System.out.println("문자열 입력 : ");
        String userInput = sc.nextLine();
        if (userInput.isBlank()) {
            System.out.println("> 유효한 문자열을 입력해주세요 ...");
        }
    }
}
