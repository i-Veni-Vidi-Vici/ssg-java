package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args) {
        System.out.println('A' + 0); //65
        System.out.println('0' + 0); //48
        System.out.println((char) 65); //'A'

        byte bnum = 125; //125
        char ch = 'C'; //'C'
        int inum = bnum - ch; // byte -> int , ch -> int, 125-67=58
        System.out.println("inum = " + inum); //58

        // 비교 연산자
        // == 같은가
        // != 다른가
        // 결과, 형변환 과정을 주석으로 작성해보세요.
        System.out.println(2.0 == 5/2); // 5/2 = 2, 2.0 == 2.0, true
        System.out.println('C' == 67); // 'C'-> 67, 67==67, true
        System.out.println('A' == 'B' + 1); // 'B'+1=67, 'A'->65, 65==67, false
        System.out.println('a' != 97); // a -> 97, 97!=97 -> false

        // 논리 연산자
    }
}
