package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args) {

        //
        System.out.println('A' + 0); // char + int -> int 65 + int 0 -> 65
        System.out.println('0'+ 0); // chat + int -> ('0')int 48 + int 0 -> 48
        System.out.println((char) 65); // 65 char -> A

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch; // byte - char -> int - int -> 125 - 67
        System.out.println("inum = " + inum); // 125 - 67 = 58

        //비교연산자
        // == 같니
        // != 다르니
        // 형변환 과정을 주석으로 작성해보세요
        System.out.println(2.0 == 5 / 2); //  double(2.0) == int(5)/int(2) 결과: int(2) -> double == int -> double == double true
        System.out.println('C' == 67); // int C= 67 true
        System.out.println('A' == 'B' + 1); // int 'A' = 65 int 'B' = 66 , 66+1 = 67 int == int-> flase
        System.out.println('a' != 97); // int 'a' 은 97 맞는데 틀렸다고 해서 -> false // char != int -> int != int
    }




}
