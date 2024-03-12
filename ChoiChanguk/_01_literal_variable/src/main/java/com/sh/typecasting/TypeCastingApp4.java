package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args)
    {
        //문자+숫자 = 아스키코드 값(정수)으로 형변환
        System.out.println('A'+0);// 65 //char+int -> int +int
        System.out.println('0'+0);// 48
        System.out.println((char) 65);// A

        byte bnum=125;
        char ch='C';
        int inum=bnum-ch;
        System.out.println("inum = "+inum);//125-67 =58

        //비교연산자
        //==같은가
        //!=다른가
        System.out.println(2.0==5/2);// 참 정수/정수 -> 실수/실수 형변환 5/2=2.0
        System.out.println('C'==67); // char->int형으로 형변환 아스키코드 C=67 이므로 참이다
        System.out.println('A'=='B'+1); //아스키코드 A=65, B=66 이므로 틀리다
        System.out.println('a'!=97); // 아스키코드 a=97이 맞으므로 식은 틀리다
        System.out.println(2.0==2);
    }
}
