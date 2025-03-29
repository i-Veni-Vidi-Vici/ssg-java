package com.sh.typecasting;

public class TypeCastingApp4 {

    public static void main(String[] args) {
        //
        System.out.println('A' + 0); //65
        System.out.println('0' + 0); //48
        System.out.println((char) 65); //'A'

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch; // 125-67=58 int - int
        System.out.println("inum = " + inum); // 58

        // 비교연산자
        // == 같은가
        // != 다른가
        System.out.println(2.0 == 5 / 2); // true double(2.0) == int(2) -> double
        System.out.println('C' == 67); // true char(67) == int -> int
        System.out.println('A' == 'B' + 1); // false char(65) == int(66) + int -> int(67)
        System.out.println('a' != 97); // false char(97) != int -> int
    }
}
