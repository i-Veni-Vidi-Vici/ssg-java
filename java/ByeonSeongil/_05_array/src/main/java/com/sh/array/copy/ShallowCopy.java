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
        int[] arr2 = arr; // arr의 주소값을 arr2에 대입

        // hashCode 비교
        System.out.println(arr.hashCode() == arr2.hashCode());

        arr[1] = 0;

        // 값 확인
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
            System.out.printf("arr2[%d] = %d\n", i, arr2[i]);
        }
    }

    /**
     * 얕은 복사 활용1: 매개인자
     */
    public void test2() {
        int[] arr = {1, 2, 3};
        System.out.println("test2 :" + arr.hashCode());
        print(arr);
    }

    public void print(int[] arr) {
        System.out.println("test2 :" + arr.hashCode());

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2 - 리턴값
     */
    public void test3() {
        String[] animals = getAnimalArray();
        System.out.println("test3 :" + animals.hashCode());

        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
    }

    public String[] getAnimalArray() {
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        System.out.println("getAnimalArray :" + animals.hashCode());
        return animals;
    }

    /**
     * 사용자로부터 두정수를 입력받아 두정수 사이의 수로 구성된 배열을 생성하세요.
     * 이때 배열 생성메서드 generateArray(from:int, to:int)를 사용하세요.
     */
    public void test4() {
        int[] result = generateArray();
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] generateArray() {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력1: ");
        int num1 = sc.nextInt();

        System.out.print("정수 입력2: ");
        int num2 = sc.nextInt();

        int[] result = new int[Math.abs(num1 - num2 )+1];

        if (num1 < num2) {
            for (int i = 0; i < result.length; i++) {
                result[i] = num1++;
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                result[i] = num2++;
            }
        }

        return result;
    }
}
