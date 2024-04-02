package com.sh.api._02.string;

import java.sql.SQLOutput;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //charAt(int) : char 특정인덱스 문자 반환
        String str = "apple";
        for(int i = 0; i< str.length(); i++){
            System.out.println("charAt : " + i + ") : "+ str.charAt(i));
        }
        System.out.println();

        //compareTo(String) : 문자열을 비교환 결과값을 정수로 반환, 정렬 사용시 내부적으로 호출됨.
        // - 0 :  같은 경우
        // - 음수 :  문자열이 작은 경우 (사전에서 앞쪽에 위치해 있는 경우를 의미함)
        // - 양수 :  문자열이 큰 경우 (사전에서 뒤쪽에 위치해 있는 경우를 의미함()

        String txt1 = "java";
        String txt2 = "java";
        String txt3 = "JAVA";
        String txt4 = "ssg";
        System.out.println("compareTo : " + txt1.compareTo(txt2)); //0
        System.out.println("compareTo : " + txt2.compareTo(txt3));//32 txt
        System.out.println("compareTo : " + txt3.compareTo(txt2));//-32
        System.out.println("compareTo : " + txt2.compareTo(txt4));//-9
        System.out.println("compareToIgnoreCase : " + txt1.compareToIgnoreCase(txt3));//-9
        System.out.println();

        //concat(String) : String 문자열 연결 연산 이후 새 문자열 반환, 연산을 한 후에도 원본 문자열은 영향을 받지 않음, 새로운 문자열을 반환하는 것이기 떄문에
        System.out.println("concat : " + txt1.concat(txt2));

        //indexOf(int) : int
        //indexOf(String) : int -> 대상문자열에서 검색한 문자열의 인덱스를 반환함 (없으면 -1 반환)
        String hello = "helloWorld";
        System.out.println("indexOf : " + hello.indexOf('W'));
        System.out.println("indexOf : " + hello.indexOf('k'));
        System.out.println("indexOf : " + hello.indexOf("loW"));
        System.out.println("lastindexOf : " + hello.indexOf('o'));

        //contains(String) : boolean
        System.out.println("contains : " + hello.contains("hell"));
        System.out.println("contains : " + hello.contains("hell"));
        System.out.println("indexOf -> bollean : " + (hello.indexOf("hell") > -1));
        // 동일한 값이 있으면 IndexOF에서 -1이 아닌 -1보다 큰 수를 반환하기 때문에 있는지 없는지 비교하기 위해서 사용함.
        System.out.println("contains : " + hello.contains("hell"));

        //trim() : String 앞 뒤의 공백을 제거하고 새로운 문자열 반환
        String space = "    ㅋㅋ ㅋㅋ";
        System.out.println("Trim : " + space.trim());

        //toLowerCase() : String
        //toUpperCase() : String


        //subString(start : int , end: int) : String start인덱스부터 end인덱스 전까지 문자열을 잘라서 반환
        String abc = "abcdefg";
        System.out.println("subString : " + abc.substring(2,5));
        System.out.println("subString : " + abc.substring(2));
        System.out.println("subString : " + abc.substring(2,abc.length()));
        System.out.println("abc = " + abc);

        //replace(target, replacement) : String 문자열의 target부분을 replacement로 변경한 새 문자열을 반환한다.
        String rep = "I hate you";
        System.out.println("replace : " + rep.replace("hate", "love"));
        System.out.println(rep);

        //isEmpyt() : boolean 문자열의 길이가 0인가 ? (""과 null은 다르다 )
        System.out.println("isEmpty : " + "".isEmpty());
        System.out.println("isEmpty : " + "abc".isEmpty());
        System.out.println("isEmpty : " + "      ".isEmpty());

//        isBlank() : boolean 공백 문자열인가 ? ("", "   ", 모두 공백 문자열이다 )
        System.out.println("isBlack : " +  "".isBlank());
        System.out.println("isBlack : " +  "    ".isBlank());

        String userInput = scanner.nextLine();
        if(userInput.isBlank()){
            System.out.println(">유효한 문자열을 입력해주세요...");
        }
    }
}
