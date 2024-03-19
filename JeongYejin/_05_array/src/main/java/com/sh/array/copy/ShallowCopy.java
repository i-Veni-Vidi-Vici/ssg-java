package com.sh.array.copy;

import java.util.Scanner;

/**
 * 얕은 복사
 * - 배열객체의 주소값을 복사
 * - 동일한 배열을 공유
 */
public class ShallowCopy {
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5};
        // 얕은 복사
        int[] arr2 = arr;

        // hashCode 비교
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        // 값변경
        arr[1] *= 10;

        // 값 확인
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr2[%d] = %d\n", i, arr2[i]);
        }
    }

    /**
     * 얕은 복사 활용 1 : 매개인자
     */

    public void test2() {
        int[] arr = {1, 2, 3};
        System.out.println(arr.hashCode());
        print(arr);
    }

    public void print(int[] arr) {
        System.out.println(arr.hashCode());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2 - 리턴값
     */
    public void test3() {
        String[] animals = getAnimalArray();
        System.out.println("test3 : " + animals.hashCode());

        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
    }

    public String[] getAnimalArray() {
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        System.out.println("getAnimalArray : " + animals.hashCode());
        return animals;
    }

    /**
     * 사용자로부터 두 정수를 입력받아 두 정수 사이의 수로 구성된 배열을 생성/출력하세요.
     * 이때 배열 생성 메소드 generateArray(from: int, to: int)를 사용하세요.
     * ({변수명}: {타입})
     */
    public void test4() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = generateArray(m, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public int[] generateArray(int from, int to) {
        int[] arr = new int[to - from + 1];
        for (int i = 0; i < arr.length; i++){
            arr[i] = from++;
        }
        return arr;
    }
}