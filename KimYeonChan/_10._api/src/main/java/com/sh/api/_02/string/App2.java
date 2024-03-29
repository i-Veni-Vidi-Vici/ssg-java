package com.sh.api._02.string;

public class App2 {
    public static void main(String[] args) {
        // charAt(int): char 특정인덱스 문자 반환
        String str1 = "apple";
        for (int i = 0; i < str1.length(); i++) {
            System.out.println(str1.charAt(i));
        }
        System.out.println();

        // compareTo(String): 문자열을 비교한 결과값을 정수로 반환.
        // - 0: 같은 경우
        // - 음수: 문자열이 작은 경우 (사전에서 앞에 나오는 경우)
        // - 양수: 문자열이 큰 경우 (사전에서 뒤에 나오는 경우)
        String txt1 = "java";
        String txt2 = "java";
        String txt3 = "JAVA";
        String txt4 = "ssg";

        System.out.println(txt1.compareTo(txt2)); // 0
        System.out.println(txt2.compareTo(txt3)); // 32
        System.out.println(txt3.compareTo(txt4)); // -41
        System.out.println(txt2.compareTo(txt4)); // -9
        System.out.println(txt1.compareToIgnoreCase(txt3)); // 0

        // concat(String):String 문자열 연결연산 이후 새 문자열 반환
        System.out.println(txt1.concat(txt2));

        // indexOf(int):int / indexOf(String):int
        // 대상 문자열에서 검색한 문자열의 인덱스 반환 (없으면 -1 반환)
        String hello = "hello";
        System.out.println(hello.indexOf('e')); // 1
        System.out.println(hello.indexOf('w')); // -1
        System.out.println(hello.indexOf("ll")); // 2
        System.out.println(hello.lastIndexOf('e')); // 1

        // contains(String):boolean
        System.out.println(hello.contains("hell"));
        System.out.println(hello.contains("hl"));
        System.out.println((hello.indexOf("hl")) > -1);

        // trim():Sting 앞뒤의 공백 제거하고 새문자열 반환
        String space = "   ㅋㅋ    ";
        System.out.println(space.trim()); // ㅋㅋ

        // toLowerCase():String
        // toUpperCase():String
        String subject = "Java";
        System.out.println(subject.toLowerCase());
        System.out.println(subject.toUpperCase());

        // substring(start:int, end:int):String
        // start 인덱스 부터 end 인덱스까지 문자열을 잘라서 반환
        String nums = "012345";
        System.out.println(nums.substring(2, 5));
        System.out.println(nums.substring(2));

        // replace(target, replacement):String 문자열의 target 부분을 replacement 로 변경한 새문자열 반환
        String word = "I hate you~";
        System.out.println(word.replace("hate", "love"));
        System.out.println(word);

        // isEmpty():boolean 문자열의 길이가 0인가? (""과 null 은 다르다)
        System.out.println("abc".isEmpty());
        System.out.println("".isEmpty());
        System.out.println("         ".isEmpty()); // false

        // isBlank():boolean 공백 문자열인가?
        System.out.println("".isEmpty());
        System.out.println("         ".isEmpty()); // true
    }
}
