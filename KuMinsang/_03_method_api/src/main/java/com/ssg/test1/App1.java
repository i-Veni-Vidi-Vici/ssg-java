package com.ssg.test1;

import java.util.Random;

/**
 * 1. 1에서 1000사이의 정수범위의 난수를 생성
 * 2. 난수출력, 생성된 난수가 300에서 600사이에 포함되는지 여부 출력
 * 구현내용 generate():void
 */
public class App1 {
    public static void main(String[] args) {
        RandomNumGenerator rnd = new RandomNumGenerator();
        rnd.generate();
    }
}
