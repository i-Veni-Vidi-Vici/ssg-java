package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args) {
        System.out.println('A' + 0); // 65 + 0 = 65, 문자와 정수의 연산이므로 결과는 정수
        System.out.println('0' + 0); // 48 + 0 = 48
        System.out.println((char) 65); // 'A', 정수 65를 char 타입으로 강제형변환

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch; // byte - char -> int - int, 정수와 문자의 연산이므로 결과는 정수, 125 - 67 = 58
        System.out.println("inum = " + inum);

        // 비교연산자
        // == 같은가
        // != 다른가
        System.out.println(2.0 == 5 / 2); // 2.0 == 2, 정수 사이의 연산 결과는 정수이므로 5/2 == 2, 실수와 정수 사이 비교연산이므로 int 2가 double 2.0으로 자동형변환
        System.out.println('C' == 67); // 67 == 67, true, char가 int형으로 자동형변환
        System.out.println('A' == 'B' + 1); // 65 == 66 + 1, false, char가 int형으로 자동형변환, char == int + int -> char == int -> int == int
        System.out.println('a' != 97); // 97 != 97, flase, char가 int형으로 자동형변환 // char != int -> int != int
    }
}
