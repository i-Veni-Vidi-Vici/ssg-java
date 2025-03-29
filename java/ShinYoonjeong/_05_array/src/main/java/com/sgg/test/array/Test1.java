package com.sgg.test.array;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.test1();
    }
    public void test1()
    {
        int[] arr = new int[100];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = i+1;
            System.out.println(arr[i]);
        }
    }
}
