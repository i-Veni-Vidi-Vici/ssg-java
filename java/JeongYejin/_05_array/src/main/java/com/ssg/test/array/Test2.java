package com.ssg.test.array;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test();
    }

    private void test() {
        String[] fruits = new String[5];
//        String fruits = new String[]{"딸기", "복숭아", "키위", "사과", "바나나"};
        fruits[0] = "딸기";
        fruits[1] = "복숭아";
        fruits[2] = "키위";
        fruits[3] = "사과";
        fruits[4] = "바나나";

        System.out.println(fruits[4]);
    }
}
