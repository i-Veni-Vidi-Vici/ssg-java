package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args) {
        //
        System.out.println('A' + 0); // 65 char + int -> int + int
        System.out.println('B' + 0); // 48 char + int -> int + int
        System.out.println((char) 65); // 'A'

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch; // byte - char -> int - int -> 125 - 67
        System.out.println("inum = " + inum); //58

        // 비교연산자
        // == 같은가
        // != 다른가

        System.out.println(2.0 == 5 / 2); // true double == int / int -> double == int -> double == double
        System.out.println('C' == 67); // true char == int -> int == int
        System.out.println('A' == 'B' + 1); // false char == char + int -> char == int + int -> char == int ->
        System.out.println('a' != 97); //
    }

}
