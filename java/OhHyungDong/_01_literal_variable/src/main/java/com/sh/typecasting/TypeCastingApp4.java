package com.sh.typecasting;

/**
 * <pre>
 *
 * </pre>
 */
public class TypeCastingApp4 {
    public static void main(String[] args) {
        System.out.println('A' + 0);// 65
        System.out.println('0' + 0); // 0에 대한아스키 코드값 + 0 = 48
        System.out.println((char)65);// A

        byte bnum = 125;
        char ch = 'C'; //67
        int inum = bnum - ch; // ch형 125 - 67  byte - char -> int - int 값으로 변환
        System.out.println("inum = " + inum); // 58

        //비교 연산자
        System.out.println(2.0 == 5/2); //true
        System.out.println('C' == 67); // true
        System.out.println('A' == 'B' + 1);//false
        System.out.println('a' != 97); //false
    }
}
