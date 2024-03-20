package com.ssg.test.array;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test();
    }

    private void test() {
        String[] fruit = {"딸기", "복숭아", "키위", "사과", "바나나"};
        for(int i = 0; i < fruit.length; i++) {

            if (fruit.equals("바나나")) {
                System.out.println(Arrays.toString(fruit));
            }
        }
    }
}
