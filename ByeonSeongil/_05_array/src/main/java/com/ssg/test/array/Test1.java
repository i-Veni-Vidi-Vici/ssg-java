package com.ssg.test.array;

public class Test1 {
    public static void main(String[] args) {
        int[] number = new int[100];
        for (int i = 0; i < number.length; i++) {
            number[i]= i+1;
            System.out.println(number[i]);
        }
    }
}
