package com.sh.array.copy;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ShallowCopy {
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5};

        int[] arr2 = arr;

        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        arr[0] = 50;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr2[i]);
        }
    }

    /**
     * 얇은 복사 활용 1 : 매개인자
     */
    public void test2() {
        int[] arr = {1, 2, 3};
        print(arr);
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public void test3() {
        String[] animals = getAnimalArray();
        System.out.println("test3 : " + animals.hashCode());
//        for (int i = 0; i < animals.length; i++) {
//            System.out.println(animals[i]);
//        }
        for (String animal : animals) {
            System.out.println(animal);
        }
    }
    public String[] getAnimalArray() {
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        System.out.println("getAnimalsArray: " + animals.hashCode());
        return animals;
    }

    /**
     * 사용자로부터 두 정수를 입력받아 두 정수 사이의 수로 구성된 배열을 생성 / 출력 하세요.
     * 이 때 배열 생성 메소드 generateArray(from:int, to:int)를 사용하세요.
     */
    public void test4() {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫번째 입력하세요");
        int a = sc.nextInt();
        System.out.println("두번째 입력하세요");
        int b = sc.nextInt();

        int[] arr = generateArray(a, b);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public int[] generateArray(int from, int to) {
        int[] arr = new int[to - from + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + from;
        }
        return arr;
    }
}
