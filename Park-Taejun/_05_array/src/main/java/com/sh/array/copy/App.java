package com.sh.array.copy;

/**
 * 배열복사
 * (모든 객체에 해당되는 사항)
 * -얕은 복사 : 주소값만 복사해서 heap영역의 같은 객체를 공유
 * -깊은 복사 : heap영역의 값이 동일한 객체를 복사
 */
public class App {
    public static void main(String[] args) {
        ShallowCopy SH = new ShallowCopy();
//        SH.test1();
//        SH.test2();
//        SH.test3();
//        SH.test4();


        DeepCopy deepCopy = new DeepCopy();
//    deepCopy.test1();
//        deepCopy.test2();
//        deepCopy.test3();
//        deepCopy.test4();
//        deepCopy.test5();
//        deepCopy.test6();
        deepCopy.test7();


    }
}
