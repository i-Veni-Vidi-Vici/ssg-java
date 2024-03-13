package com.sh.math;

/**
 * <pre>
 * 난수 생성하기
 * - Math.random():double// -> static메소드이며 return이 double 이라는 뜻이다
 * - 0.0~1.0 미만
 * - 특정 범위 난수 생성 공식 : (int)Math.random() * 경우의 수+최소값
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        //0.1 ~ 1.0미만, !!주의 괄호를 잘보고 int 형 변환을 한다
        System.out.println("0.1 ~ 1.0미만 난수 : "+Math.random());

        //0 ~ 9, !!주의 괄호를 잘보고 int 형 변환을 한다
        System.out.println((int)(Math.random()*10));

        //1 ~ 10 난수
        System.out.println(("1 ~ 10 난수 : "+(int)(Math.random()*10+1)));

        //3 ~ 5 사이 난수
        System.out.println("3 ~ 5 난수 : "+Math.random()*3+3);

        //10 ~ 15 사이 난수
        System.out.println("10 ~ 15 난수 : "+Math.random()*6+10);

        //-128 ~ 127 사이 난수
        System.out.println("-128 ~ 127 난수 : "+Math.random()*256+ -128);
    }
}
