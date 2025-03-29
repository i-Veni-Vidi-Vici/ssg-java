package com.sh.api._02.string;

import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //charAt(int) : char 특정 인덱스 문자 반환
        String str = "apple"; //0 1 2 3 4
        for (int i = 0; i<str.length(); i++) {
            System.out.println("chatAt(" + i + ") : " + str.charAt(i));
        }
        System.out.println();

        //compareTo(String) : 문자열을 비교한 결과값을 정수로 반환
        //- 0 같은 경우
        //- 음수  : 문자열이 작은 경우(사전에서 앞에 나온 경우)
        //- 양수 : 문자열이 큰 경우(사전에서 뒤에 나온경우)

        String txt1 = "java";
        String txt2 = "java";
        String txt3 = "JAVA";
        String txt4 = "ssg";
        System.out.println("compareTo : " + txt1.compareTo(txt2)); //0
        System.out.println("compareTo : " + txt2.compareTo(txt3)); //32 -> 2의 j가 3의 J보다 32 뒤에 있다
        System.out.println("compareTo : " + txt3.compareTo(txt2)); //-32 -> 3의 J가 2의 j보다 32 앞에 있따.
        System.out.println("compareTo : " + txt2.compareTo(txt4)); //-9 -> 3의 j가 4의 s보다 32 앞에 있다.
        System.out.println("compareToIgnoreCase : " + txt1.compareToIgnoreCase(txt3)); //0 -> 3의 j가 4의 s보다 32 앞에 있다.
        System.out.println();

        //concat(String) : String 문자열 연결연산 이후 새 문자열 반환
        System.out.println("concat : " + txt1.concat(txt2)); //javajava
        System.out.println("txt1 = " + txt1 + ", txt2 = " + txt2);
        System.out.println();

        //indexOf(int) : int
        //indexOf(String) : int 대상 문자열에서 검색한 문자열의 인덱스 반환(없으면 -1 반환)
        String helloworld = "helloworld";
        System.out.println("indexOf : " + helloworld.indexOf('w')); //5
        System.out.println("indexOf : " + helloworld.indexOf('z')); //-1
        System.out.println("indexOf : " + helloworld.indexOf("low")); //3
        System.out.println("lastIndexOf : " + helloworld.lastIndexOf('o')); //6, 인덱스의 순서가 바뀌지는 않음

        //trim( ) : String 앞뒤의 공백 제거하고 새문자열 반환
        String space = "         ㅋㅋㅋ       ";
        System.out.println("trim : |" + space.trim() + "|");
        System.out.println("space : |" + space+ "|");
        System.out.println();

        //toLowerCase() : String
        //toUpperCase() : String
        String subject = "Java";
        System.out.println("toLowerCase : " + subject.toLowerCase());
        System.out.println("toLowerCase : " + subject.toUpperCase());
        System.out.println("맞습니까? (Y/N) : ");
//        char choice = sc.next().charAt(0);
//        System.out.println(choice == 'y');

        System.out.println();

        //substring(start : int, end : int) : String start인덱스부터 end 인덱스 전까지 문자열을 잘라서 반환
        String abc = "abcdefg";
        System.out.println("substring : " + abc.substring(2, 5)); //cde
        System.out.println("substring : " + abc.substring(2)); //cdefg
        System.out.println("substring : " + abc.substring(2, abc.length())); //cdefg
        System.out.println("abc = " + abc);


        //replace(target, replacement): String 문자열의 target부분을 replacement로 변경한 새 문자열을 반환
        String word = "I hate you~";
        System.out.println("replace : " + word.replace("hate", "love"));
        System.out.println("word = " + word);

        //isEmpty() : boolean 문자열의 길이 0인가? (""과 null은 다름)
        System.out.println("isEmpty : " + "".isEmpty()); // true
        System.out.println("isEmpty : " + "abc".isEmpty()); //false
        System.out.println("isEmpty : " + "      ".isEmpty()); //false

        //isBlank() : boolean 공백문자열인가?(””, “    “ 모두 공백 문자열임)
        System.out.println("isBlank : " + "".isBlank()); //true
        System.out.println("isBlank : " + "           ".isBlank()); //true
        System.out.println("isBlank : " + "ㅋㅋㅋㅋㅋㅋㅋ".isBlank()); //false

        System.out.print("문자열을 입력해주세요 : ");
        String userInput = sc.nextLine();
        if (userInput.isBlank()) {
            System.out.print(" > 유효한 문자열을 입력해주세요.");
        }

        //contains(String) : boolean
        System.out.println("contains : " + helloworld.contains("hell"));
        System.out.println("contains : " + helloworld.contains("ㅋㅋㅋ"));
        System.out.println("indexOf -> boolean : " + (helloworld.indexOf("hell") > -1));
        System.out.println("indexOf -> boolean : " + (helloworld.indexOf("ㅋㅋㅋ") > -1));
        System.out.println();
    }
}
