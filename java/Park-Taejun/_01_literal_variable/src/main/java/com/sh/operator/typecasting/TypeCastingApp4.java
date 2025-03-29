package com.sh.operator.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args){
        //
        System.out.println('A' + 0); // 65 char + int -> int + int
        System.out.println('0' + 0); // 48 char + int -> int + int
        System.out.println((char) 65); //

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch; // byte - char -> int - int -> 125 - 67
        System.out.println("inum = " + inum); // 58

        // 비교연산자
        // ==같은가
        // != 다른가
        // 결과, 형변환 과정을 주석으로 작성해보세요.
        System.out.println(2.0 == 5 / 2);//double == int / int -> double -- int -> double ==double
        System.out.println('C' == 67);// char == int --> int == int
        System.out.println('A' == 'B' + 1);// char == char + int -> char == int + int
        System.out.println('a' !=97); //char != int -> int -> int

    }
}
