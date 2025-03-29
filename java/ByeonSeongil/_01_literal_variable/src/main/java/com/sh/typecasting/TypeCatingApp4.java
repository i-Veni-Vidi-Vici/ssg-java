package com.sh.typecasting;

public class TypeCatingApp4 {
    public static void main(String[] args) {
        //
        System.out.println('A' + 0); // char + int -> int + int 65
        System.out.println('0' + 0); // 48
        System.out.println((char) 65); // A

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch; // byte - char -> int - int -> 125-67
        System.out.println("inum = " + inum); // inum = 58


        // 비교연산자
        // == 같은가
        // != 다른가
        // 형변환 과정을 주석으로 작성해보세요.
        System.out.println(2.0 == 5 / 2); // double == int / int -> double == int -> double == double true
        System.out.println('C' == 67); // char == int -> int == int  true
        System.out.println('A' == 'B' + 1); // char == char + int -> char == int + int -> char == int -> int == int false
        System.out.println('a' != 97); // char != int -> int != int, false
    }
}
