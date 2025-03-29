package com.ssg.test.array;

public class Test1 {
    public static void main(String[] args) {
        int[] number = new int[101];

        for(int i = 0; i<number.length;i++)
        {
            number[i] = i+1;
        }
        for(int i = 0; i<number.length-1;i++)
        {
            System.out.print(number[i] + " ");
        }
    }
}
