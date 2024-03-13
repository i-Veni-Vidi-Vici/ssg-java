package com.ssg.test1;

public class RandomNumGenerator {

//    구현 내용 :
//    `generate():void`
//      1. 1에서 1000사이의 정수범위의 난수를 생성
//      2. 난수출력, 생성된 난수가 300에서 600사이에 포함되는지 여부 출력

    public void generate() {
        // 1 ~ 1000
        int rnd = (int)(Math.random() * 1000) +1;
        // 난수가 300에서 600사이에 포함되는지 여부 출력
        System.out.println(rnd + "는 300 ~ 600사이에 " + ((rnd >= 300 && rnd <= 600) ? "포함" : "불포함"));
    }
}
