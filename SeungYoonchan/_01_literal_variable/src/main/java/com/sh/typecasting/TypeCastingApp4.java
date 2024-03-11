package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args){
        System.out.println('A' + 0);    // 'A' == 65 | char -> int 형변환 | 65+0 == 65
        System.out.println('0' + 0);    // '0' == 48 | char -> int 형변환 | 48+0 == 48
        System.out.println((char)65);   // 65는 ascii code 표에서 char 'A' 로 형변환

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum - ch;
        System.out.println("inum = " + inum); // 125 에서 형변환 된 'C' == 67을 '-' 한 값은 58 | 기본 계산은 int로 자동 형변환

        System.out.println(2.0 == 5/2);     // 5/2 는 정수끼리 계산으로 몫만 나오기 때문에 2가 나와서 True
        System.out.println('C' == 67);      // 'C' 의 ascii code는 67이기 때문에 True
        System.out.println('A' == 'B' + 1); // 'A' == 65 , 'B' == 66 이므로 66+1은 67이기 때문에 False
        System.out.println('a' != 97);      // 'a' == 97 이기 때문에 False
    }
}
