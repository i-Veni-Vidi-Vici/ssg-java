package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args) {
        //
        System.out.println();

        System.out.println('0' + 0);
        System.out.println((char) 65);

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch;
        System.out.println("inum = " + inum);


        System.out.println(2.0 == 5/ 2);
        System.out.println('C' == 67);
        System.out.println('A' == 'B' + 1);
        System.out.println('a' != 97);
    }
}
