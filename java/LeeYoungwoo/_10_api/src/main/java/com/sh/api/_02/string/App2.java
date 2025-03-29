package com.sh.api._02.string;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. charAt(int):char 특정인덱스 문자반환
        String str = "apple";
        for (int i = 0; i <str.length(); i++) {
            System.out.println("charAt(" + i + ") : " + str.charAt(i));
        }
        System.out.println();

        // 2. compareTo(String) : 문자열을 비교한 결과값을 정수로 반환. 정렬 사용시 내부적으로 호출.
          // 0 : 같은 경우
          // 음수 : 문자열이 작은경우 (사전에서 앞에 나오는 경우)
          // 양수 : 문자열이 큰경우 (사전에서 뒤에 나오는 경우)
        String txt1 = "java";
        String txt2 = "java";
        String txt3 = "JAVA";
        String txt4 = "ssg";
        System.out.println("comepareTo : " + txt1.compareTo(txt2)); // 0
        System.out.println("comepareTo : " + txt2.compareTo(txt3));
            // 32 -> 아스키코드보면 대문자가 소문자보다 앞에 나오기 때문에 txt2의 첫글자가 txt3의 첫글자보다 32만큼 앞에 있다는 뜻
        System.out.println("comepareTo : " + txt3.compareTo(txt4)); // -41
        System.out.println("comepareTo : " + txt2.compareTo(txt4)); // -9
        System.out.println("comepareToIgnoreCase : " + txt2.compareToIgnoreCase(txt3)); // 0 -> 대,소문자 무시하고 비교
        System.out.println();

        // 3. concat(String):String 문자열 연결연산 이후 새 문자열 반환
        System.out.println("concat : " + txt1.concat(txt2)); // javajava
        System.out.println("txt1 : " + txt1 + ", " + "txt2 : " + txt2); // 원본문자열은 변하지 않는다.
        System.out.println();

        // 4.  indexOf(int):int
        // 4-1 indexOf(String):int 대상문자열에서 검색한 문자열의 인덱스 반환 (없으면 -1 반환)
        String helloworld = "helloworld";
        System.out.println("indexOf : " + helloworld.indexOf('w')); // 5
        System.out.println("indexOf : " + helloworld.indexOf('z')); // -1
        System.out.println("indexOf : " + helloworld.indexOf("low")); // 3 시작지점 인덱스
        System.out.println("lastIndexOf : " + helloworld.lastIndexOf("low")); // 6 끝지점 인덱스
        System.out.println();

        // contains(String):boolean true/false 반환
        System.out.println("contains : " + helloworld.contains("hell")); //true
        System.out.println("contains : " + helloworld.contains("ㅋㅋㅋ")); // false
        System.out.println("indexOf -> boolean : " + (helloworld.indexOf("hell") > -1)); // true
        System.out.println();

        // 5. trim():String 앞뒤의 공백을 제거하고 새 문자열 반환
        String space = "        ㅋㅋㅋㅋ        ";
        System.out.println("trim : |" + space.trim() + "|"); // ㅋㅋㅋㅋ
        System.out.println("space : |" + space + "|"); // 원본 문자열은 변하지 않음
        System.out.println();

        // 6.  toLowerCase():String
        // 6-1 toUpperCase():String
        String subject = "java";
        System.out.println("toLowerCase : " + subject.toLowerCase()); // java
        System.out.println("toUpperCase : " + subject.toUpperCase()); // JAVA

//        System.out.println("맞습니까? (Y/N)");
//        char choice = sc.next().toLowerCase().charAt(0);
//        System.out.println(choice == 'y'); // 대소문자 상관없이 true로 받을 때
        System.out.println();

        // 7. substring(start:int, end:int):String start인덱스부터 end인덱스 전까지 문자열을 잘라서 반환
        String abc = "abcdefg";
        System.out.println("substring : " + abc.substring(2, 5)); // cde -> end인덱스는 포함X
        System.out.println("substring : " + abc.substring(2)); // cdefg
        System.out.println("substring : " + abc.substring(2, abc.length())); // cdefg
        System.out.println("abc = " + abc); // 원본문자열은 변하지 않음
        System.out.println();

        // 8. replace(target, replacement):String 문자열의 target 부분을 replacement로 변경한 새 문자열을 반환
        String word = "I hate you!";
        System.out.println("replace : " + word.replace("hate", "love"));
        System.out.println("word : " + word);
        System.out.println();

        // 9. isEmpty():boolean 문자열의 길이가 0인가? ("" 과 null은 다르다)
        System.out.println("isEmpty : " + "".isEmpty()); // true
        System.out.println("isEmpty : " + "a123".isEmpty()); // false
        System.out.println("isEmpty : " + "     ".isEmpty()); // false
        System.out.println();

        // 9-1. isBlank():boolean 공백문자열인가? ("", "    " 모두 공백 문자열이다.)
        System.out.println("isBlank : " + "".isBlank()); // true
        System.out.println("isBlank : " + "     ".isBlank()); // true
        System.out.println("isBlank : " + "ㅋㅋㅋㅋ".isBlank()); // false

//        System.out.println("문자열 입력 : ");
//        String userInput = sc.nextLine();
//        if (userInput.isBlank()) {
//            System.out.println("> 유효한 문자열을 입력해주세요");
//        }


    }
}
