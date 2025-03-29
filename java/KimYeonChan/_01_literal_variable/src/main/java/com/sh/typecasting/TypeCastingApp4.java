package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args) {
        System.out.println('A' + 0);            // char + int -> int + int => 65
        System.out.println('0' + 0);            // char + int -> int + int => 48
        System.out.println((char) 65);          // int => A

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch;                   // byte - char -> int - int => 58
        System.out.println("inum: " + inum);

        System.out.println(2.0 == 5 / 2);       // double == int / int -> double == int -> double == double => true
        System.out.println('C' == 67);          // char == int -> int == int => true
        System.out.println('A' == 'B' + 1);     // char == char + int -> int == int + 1 => false
        System.out.println('a' != 97);          // char != int -> int != int => false
    }
}
