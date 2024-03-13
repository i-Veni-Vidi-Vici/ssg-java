package com.ssg.test1;

public class RandomNumGenerator {
    public void generate() {
        // 1. 1에서 1000사이의 정수범위의 난수를 생성
        int num = ((int) (Math.random() * 1000)) + 1;

        // 2. 난수출력, 생성된 난수가 300에서 600사이에 포함되는지 여부 출력
        String isIncluded = ((300 < num) && (num < 600))? "포함된다." : "포함되지 않는다.";
        System.out.println("난수: " + num + ", 생성된 난수는 300에서 600 사이 범위에 " + isIncluded);
    }
}
