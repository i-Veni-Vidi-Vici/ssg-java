package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args){
        // 코드 옆 주석 -> 내가 쓴 것. | 코드 아래 주석 -> 강사님이 쓴 형변환 과정.
        System.out.println('A' + 0); // char를 int로 변환 후 대입연산 65 + 0 == 65 | 결과: 65
//        char + int -> int + int
        System.out.println('0' + 0); // char를 int로 변환 후 대입연산 48 + 0 == 48 | 결과: 48
//        char + int -> int + int
        System.out.println((char) 65); //  ascii 코드 값 65 == A | 결과: A \
//        캐스팅 형변환

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch;
        System.out.println("inum = " + inum); // int = byte - char -> 125 - 67 = | 결과: inum = 58
//        byte - char -> int - int -> 125 - 67 = 58

        // 비교연산자
        // == 같은가
        // != 다른가
        // 결과, 형변환 과정을 주석으로 작성
        System.out.println(2.0 == 5 / 2); // 정수/정수 = 실수/실수 형변환 (O) | true
//        double == int / int double == int -> double == double
        System.out.println('C' == 67); // 67 == 67 (O) | true
//        char == int -> int == int
        System.out.println('A' == 'B' + 1); // 65 == 66 + 1 (X) | false
//        char == char + int -> char == int + int -> char == int -> int == int
        System.out.println('a' != 97); //  97 != 97 (X) | false
//        char != int -> int != int 
    }
}
