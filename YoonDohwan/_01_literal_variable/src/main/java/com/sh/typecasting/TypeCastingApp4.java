package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args){
        //
        System.out.println('A'+0);// 65
        System.out.println('0'+0);// 48
        System.out.println((char)65); //A
        byte bnum=125;
        char ch = 'C';
        int inum = bnum - ch;
        System.out.println("inum = " + inum); //inum=58
        //비교연산자
        //==같은가
        //!= 다른가
        System.out.println(2.0 == 5/2); //true  2.0== 2
        System.out.println('C'==67);     //true  67=67
        System.out.println('A'=='B'+1); //false  65!=67
        System.out.println('a'!=97);   //false   97=97

    }
}
