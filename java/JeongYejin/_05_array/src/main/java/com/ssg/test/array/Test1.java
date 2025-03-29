package com.ssg.test.array;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.test();
    }
    private void test() {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i+1;
            System.out.printf("arr[%d] : %d\n", i, arr[i]);
        }
    }


}
