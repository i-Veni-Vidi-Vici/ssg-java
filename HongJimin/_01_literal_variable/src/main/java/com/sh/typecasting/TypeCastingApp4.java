package com.sh.typecasting;

/**
 *
 */
public class TypeCastingApp4 {
    public static void main(String[] args) {
        //
        System.out.println('A' + 0); // char + int -> int + int -> int
        System.out.println('0' + 0); // char + int  -> int + int => int
        System.out.println((char) 65); //int -> char

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch; // byte - char -> int - int > 125 - 67
        System.out.println("inum = " + inum);

        //비교연산자
        // == 같은 가?
        // != 다른가?
        // 결과, 형변환 과정을 주석으로 작성해보세요!
        System.out.println(2.0 == 5 / 2); //  double ==  int/int -> double == int -> double == double => true
        System.out.println('C' == 67); // char == int -> int == int => true
        System.out.println('A' == 'B' + 1); // char == char + int -> char == int + int -> char == int -> int == int => false
        System.out.println('a' != 97); // char != int -> int != int => false




    }
}
