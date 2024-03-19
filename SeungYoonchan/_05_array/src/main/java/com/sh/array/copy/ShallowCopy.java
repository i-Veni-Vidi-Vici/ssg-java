package com.sh.array.copy;

import java.util.Scanner;

/**
 * <pre>
 *     얕은 복사
 *     - 배열 객체의 주소값을 복사
 *     - 동일한 배열을 공유
 * </pre>
 */
public class ShallowCopy {
    public void test1() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = arr1; // arr1의 주소값을 arr2에 대입

        // hashCode 비고
        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());

        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("arr1[%d] = %d\t", i, arr1[i]);
            System.out.printf("arr2[%d] = %d\n", i, arr2[i]);
        }
    }

    /**
     * 얕은 복사 활용 1: 매개 인자
     */
    public void test2(){
        int[] arr = {1, 2, 3};
        print(arr);
        System.out.println(arr[0]);
    }

    public void print(int[] arr) {
        arr[0] = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2 - 리턴값
     */
    public void test3(){
        String[] animals = getAnimalArray();
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
    }

    public String[] getAnimalArray() {
        String[] animalArray = {"낙타", "청개구리", "나무늘보"};
        return animalArray;
    }

    /**
     * 사용자로부터 두 정수를 입력받아 두 정수 사이의 수로 구성된 배열을 생성 / 출력
     */
    public void test4(){
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 1 : ");
        int num1 = sc.nextInt();

        System.out.print("정수 2 : ");
        int num2 = sc.nextInt();

        int[] arr = generateArray(num1, num2);

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    public int[] generateArray(int num1, int num2) {
        int[] arr = new int[Math.abs(num2 - num1 + 1)];

        for (int i = 0; i < arr.length; i++) {
            if (num1 < num2) {
                arr[i] = num1 + i;
            }
            else {
                arr[i] = num2 + i;
            }
        }

        return arr;
    }
}
