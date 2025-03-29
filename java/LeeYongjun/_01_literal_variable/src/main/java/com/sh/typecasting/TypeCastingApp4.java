package com.sh.typecasting;

public class TypeCastingApp4 {
    public static void main(String[] args) {
        //
        System.out.println('A' + 0); // 65 - 아스키코드표에 따른 변환값
        System.out.println('0' + 0); // 48 - 아스키코드표에 따른 변환값
        System.out.println((char) 65); // A - 65라는 값을 char값으로 변환한 값

        byte bnum = 125;
        char ch = 'C';
        int inum = bnum -ch; //125 - 67 = 58 - byte의 125라는 값을 int형으로 변환하고 char의 c값을 아스키코드표에 따라 99로 변환 후 계산
        System.out.println("inum = " + inum);

        // 비교연산자
        // == 같은가
        // != 다른가
        // 형변환 과정을 주석으로 작성해보세요.
        System.out.println( 2.0 == 5 / 2); // true - 2.0 == 2 -> 2.0 == 2.0 -> true
        System.out.println('C' == 67); // true - 아스키코드표에 따라 C는 67임으로 true
        System.out.println('A' == 'B' + 1); // false - A는 65 B는 66 임으로 B에 1을 더한값은 C이므로 false
        System.out.println('a' != 97); // false - a의 값은 97이므로 false
    }
}
