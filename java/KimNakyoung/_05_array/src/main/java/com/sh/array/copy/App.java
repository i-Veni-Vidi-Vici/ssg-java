package com.sh.array.copy;

/**
 * 배열복사
 * (모든 객체에 해당되는 사항)
 * - 얕은 복사 : 주솟값만 복사해서 heap영역의 같은 객체를 공유
 * - 깊은 복사 : heap영역의 값이 동일한 객체를 복사. 같은 객체를 공유하지 않음
 *
 *
 */

public class App {
    public static void main(String[] args) {
        ShallowCopy shallowCopy = new ShallowCopy();
//        shallowCopy.test1();
//        shallowCopy.test2();
//        shallowCopy.test3();
//        shallowCopy.test4();
        DeepDopy deepdopy = new DeepDopy();
//        deepdopy.test1();
//        deepdopy.test2();
//        deepdopy.test3();
//        deepdopy.test4();
//        deepdopy.test5();
//        deepdopy.test6();
        deepdopy.test7();
    }


}
