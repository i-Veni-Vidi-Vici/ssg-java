package com.ssg.test.array;

public class Test1{
    public static void main(String[] args) {
        // 길이가 100인 배열 선언.
        int[] array = new int[100];

        // 1부터 100까지의 값을 순서대로 배열에 넣고 출력.
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
            System.out.println("인덱스: " + i + ", 값: " + array[i]);
        }
    }
}
