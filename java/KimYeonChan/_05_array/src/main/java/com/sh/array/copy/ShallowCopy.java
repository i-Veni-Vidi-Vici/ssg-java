package com.sh.array.copy;

import java.util.Scanner;

/**
 * 얕은 복사
 * - 배열객체의 주소값을 복사
 * - 동일한 배열을 공유
 */
public class ShallowCopy {
    public void test1() {
        int[] arr1 = {1, 2, 3, 4, 5};
        // 얕은 복사
        int[] arr2 = arr1; // arr1의 주소 값을 arr2에 대입한다.

        // hashCode 비교
        System.out.println("arr1: " + arr1);
        System.out.println("arr2: " + arr2);

        // 값변경
        arr1[0] *= 10;

        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("arr1[%d] = %d\n", i, arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("arr2[%d] = %d\n", i, arr2[i]);
        }
    }

    /**
     * 얕은 복사 활용1: 매개인자
     */
    public void test2() {
        int[] arr = {1, 2, 3};
        print(arr);
        System.out.println("test2: " + arr.hashCode());
        for (int i = 0; i < arr.length; i++ ) {
            System.out.print(arr[i] + " ");
        }
    }

    public void print(int[] arr) {
        System.out.println("print: " + arr.hashCode());
        for (int i = 0; i < arr.length; i++ ) {
            System.out.print(arr[i] + " ");
            arr[i] *= 10;
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2: 리턴값
     */
    public void test3() {
        String[] animals = getAnimalArray();
        System.out.println("animals: " + animals.hashCode());
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
    }

    public String[] getAnimalArray() {
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        System.out.println("getAnimalArray: " + animals.hashCode());
        return animals;
    }

    /**
     * 사용자로 부터 두 정수를 입력 받아 두 정수 사이의 수로 구성된 배열을 생성/출력하세요.
     * 이때 배열 생성메소드 generateArray(from: int, to: int)를 사용하세요.
     */
    public void test4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("시작 정수 입력: ");
        int from = sc.nextInt();
        System.out.print("끝 정수 입력: ");
        int to = sc.nextInt();

        int[] arr = generateArray(from, to);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int[] generateArray(int from, int to) {
        int[] arr = new int[to - from + 1];
        for (int i = 0, value = from; i < arr.length; i++, value++) {
            arr[i] = value;
        }
        return arr;
    }
}
