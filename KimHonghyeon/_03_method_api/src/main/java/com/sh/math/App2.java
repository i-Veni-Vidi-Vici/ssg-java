package com.sh.math;


/**
 *
 * 난수 생성하기
 * - Math.random(): double
 * - 0.0 ~ 1.0 범위의 실수 반환
 * - 특정범위의 난수 생성: (int)(Math.random() * 경우의 수) + 최소값(offset)
 */
public class App2 {

    public static void main(String[] args) {
        //0~9사이의 난수 생성
        System.out.println((int)(Math.random()*10));
        //1~10사이
        System.out.println((int)(Math.random()*10)+1);
        //3~5
        System.out.println((int)(Math.random()*3) + 3);
        //10~15
        System.out.println((int)(Math.random()*6)+10);
        //-128~127
        System.out.println((int)(Math.random()*256)-128);
    }
}
