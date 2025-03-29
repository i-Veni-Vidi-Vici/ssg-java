package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args){
        //
        System.out.println('A' + 0);    // 65 | char -> int 형변환 | 'A' == 65 | 65 + 0 = 65
        System.out.println('0' + 0);    // 48 | char -> int 형변환 | '0' == 48 | 48 + 0 = 48
        System.out.println((char) 65) ; // A  | 65 == char 'A' 로 형변환

        byte bnum = 125;
        char ch   = 'C';
        int inum  = bnum - ch; // inum = 58 | byte - char -> int - int -> 125 - 67
        System.out.println("inum = " + inum);

        // 비교연산자
        // == 같은가
        // != 다른가
        // 형변환 과정을 주석으로 작성해보자
        System.out.println(2.0 == 5 / 2);   // true  | double == int/int -> double == int -> int == int
        System.out.println('C' == 67);      // true  | char == int -> int == int
        System.out.println('A' == 'B' + 1); // false | char == char + int -> char == int + int -> int == int
        System.out.println('a' != 97);      // false | char != int -> int != int

    }
}
