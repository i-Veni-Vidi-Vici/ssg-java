package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args) {
        System.out.println('A' + 0);            // 65
        System.out.println('0' + 0);            // 48
        System.out.println((char) 65);          // A

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch;                   // 125 - 67 = 58
        System.out.println("inum = " + inum);   // 58

        // 비교연산자
        System.out.println(2.0 == 5 / 2);       // 2.0 == 2 -> 2.0 == 2.0 -> true
        System.out.println('C' == 67);          // 67 == 67 -> true
        System.out.println('A' == 'B' + 1);     // 'A' == 66 + 1 -> 65 == 67 -> false
        System.out.println('a' != 97);          // 97 != 97 -> false
    }
}
