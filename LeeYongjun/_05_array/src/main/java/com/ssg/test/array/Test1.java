package com.ssg.test.array;

import com.sh.array.Array1;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.test();
    }

    private void test() {
        int[]arr = new int[100];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
            System.out.println(arr[i] + " ");
        }
    }
}
