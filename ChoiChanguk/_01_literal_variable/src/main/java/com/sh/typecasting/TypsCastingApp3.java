package com.sh.typecasting;

/**
 * <pre>
 * 예외적인 형변환 케이스
 * - 정수값을 char에 대입하는 경우 자동변환 처리된다
 * - int보다 작은 정수형 연산은 모두 int로 변환 후 처리
 * </pre>
 */
public class TypsCastingApp3 {
    public static void main(String[] args){
        //정수를 무자에 대입하는 경우
        char ch=97;
        System.out.println(ch);

        ch = 45000;// char 2byte이므로 65536(0~65536)의 값을 표현
        // 범위를 벗어난 수는 컴파일 에러가 난다.
        System.out.println(ch);

        //byte, short 연산
        byte bnum1=10;
        byte bnum2=20;
        //byte bresult=bnum1+bnum2; //byte+byte는 대표적인 숫자가 int이기 때문에 int로 인식을 한다 그래서 오류가 난다
    }
}
