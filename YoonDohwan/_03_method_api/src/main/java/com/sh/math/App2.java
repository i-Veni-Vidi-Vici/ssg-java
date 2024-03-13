package com.sh.math;

/**
 * Math.random():double
 * -0.0이상 ~1.0 미만의 실수를 반환
 * -특정범위의 난수 생성 공식 : (int)Math.random() * 경우의수
 */
public class App2 {
    public static void main(String[] args){
        //0~9사이의 난수 생성
        System.out.println((int)(Math.random()*10));
        //1~10사이의 난수 생성
        System.out.println((int)(Math.random()*10)+1);
        //3~5사이의 난수 생성
        System.out.println((int)(Math.random()*3)+3);
        //10~15사이의 난수 생성
        System.out.println((int)(Math.random()*6)+10);
        //-128~127사이의 난수 생성
        System.out.println((int)(Math.random()*256)-128);
    }
}
