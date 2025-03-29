package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args) {

        System.out.println('A'+0);// 65
        System.out.println('0'+0);// 48
        System.out.println((char)65); //A
        byte bnum=125;
        char ch = 'C';
        int inum = bnum - ch;   // int - int캐스팅
        System.out.println("inum = " + inum); //inum=58

        //비교 연산자
        // == 같은가
        // != 다른가
        // 결과, 형변환 과정을 주석으로 작성해보시오
        boolean k = false;
        //논리 연산자는 사칙 연산자보다 후 우선순위이다
        System.out.println(5/2);
        System.out.println(2.0 == 5 / 2); //T 5/2 = 2 (소수점 버림) 2.0 == 2? 2를 double로 캐스팅 2.0==2.0 true
        System.out.println('C' == 67);  // C=67 이므로 char->int 형변환 67==67? T
        System.out.println('A' == 'B'+1); //F A=65 B=66 사칙연산자가 우선순위가 높으므로 65 == 67? F
        System.out.println('A' == 'B'-1); //T B-1이 먼저 int - int 연산되어 65==65? T
        System.out.println('a' != 97);  // F a를 int 타입캐스트 97 !=97 ? F

    }
}
