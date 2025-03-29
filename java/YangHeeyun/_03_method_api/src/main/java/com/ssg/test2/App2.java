package com.ssg.test2;

// import static com.ssg.tet2.RandomUtils.generate;

public class App2 {
    public static void main(String[] args){
        // generate가 static이므로 객체 생성없이 바로 메소드를 사용할 수 있다.
        RandomIUtils.generate();
        // generate();만 쓰고싶으면 위에 import문이 있어야 한다.
    }
}
