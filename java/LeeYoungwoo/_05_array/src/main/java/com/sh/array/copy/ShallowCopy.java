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
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        // 값 변경
        arr[1] *= 10; // arr과 arr2는 같은 주소값을 가지기 때문에 arr의 값을 변경하면 arr2도 변경된다.

        // 값 비교
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("arr2[%d] = %d\n", i, arr[i]);
        }
    }

    /**
     * 얕은 복사 활용 1 : 매개인자
     */
    public void test2() {
        int[] arr = {1, 2, 3};
        System.out.println("test2 : " + arr.hashCode());
        print(arr);

    }

    public void print(int[] arr) {
        System.out.println("print :" + arr.hashCode());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2 : 리턴값
     */
    public void test3() {
        String[] animals = getAnimalArray();
        System.out.println("test3 : " + animals.hashCode());
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
    }

    public String[] getAnimalArray() {
        String[] animals = {"낙타", "개구리", "코끼리"};
        System.out.println("getAnimalArray : " + animals.hashCode());
        return animals;
    }

    /**
     * 사용자로부터 두 정수를 입력받아 두 정수 사이의 수로 구성된 배열을 생성하세요.
     * 이때 배열 생성메소드 generateArray(From:int, to:int)를 사용하세요.
     */
    public void test4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수입력1 : ");
        int num1 = sc.nextInt();
        System.out.println("> 정수입력2 : ");
        int num2 = sc.nextInt();

        int[] arr = generateArray(num1, num2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public int[] generateArray(int num1, int num2) {

        // 첫번째 정수가 두번째 정수보다 작은경우
        if (num1 < num2) {
            int num = num2 - num1 - 1;
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = ++num1;
            }
            return arr;
        // 첫번째 정수가 두번째 정수보다 큰경우
        } else {
            int num = num1 - num2 - 1;
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = --num1;
            }
            return arr;
        }
    }

//    public int[] generateArray(int from, int to) {
//        int len = to - from + 1;
//        int[] arr = new int[len];
//        for(int i = 0, value = from; i < arr.length; i++, value++) {
//            arr[i] = value;
//        }
//        return arr;
//    }
}
