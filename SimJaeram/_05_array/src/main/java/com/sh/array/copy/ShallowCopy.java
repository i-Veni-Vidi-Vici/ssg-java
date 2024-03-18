package com.sh.array.copy;

import java.util.Scanner;

/**
 * <pre>
 *     배열 복사
 *     (모든 객체에 해당되는 사항)
 *     - 얕은 복사 : 배열 객체의 주소값만 복사, heap영역의 같은 객체를 공유
 *     - 깊은 복사 : heap 영역의 값이 동일한 객체를 복사, 같은 객체를 공유하지 않음.
 * </pre>
 */

public class ShallowCopy {
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5};
        // 얉은 복사
        int[] arr2 = arr; // arr의 주소값을 arr2에 대입

        // hashCode 비교
        System.out.println(arr.hashCode()); // 2055281021
        System.out.println(arr2.hashCode()); // 2055281021

        // 값 변경
        arr[1] *= 10;

        // 값 출력
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
        for(int i = 0; i < arr2.length; i++) {
            System.out.printf("arr2[%d] = %d\n", i, arr2[i]);
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
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용 2 : 리턴값
     */
    public void test3() {
        String[] animals = getAnimalArray();
        System.out.println("test3 : " + animals.hashCode());

        for(int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
    }

    public String[] getAnimalArray() {
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        System.out.println("getAnimalArray : " + animals.hashCode());
        return animals;
    }

    /**
     * 사용자로부터 두 정수를 입력 받아, 두 정수 사이의 수로 구성된 배열을 생성하세요.
     * 이때 배열 생성 메소드 generateArray(from:int, to:int)를 사용하세요.
     */

    public void test4() {
        Scanner sc = new Scanner(System.in);
        int from;
        int to;
        int[] arr;

        // 사용자로부터 두 정수 입력
        System.out.print("첫번째 정수 입력 : ");
        from = sc.nextInt();
        System.out.print("두번째 정수 입력 : ");
        to = sc.nextInt();

        // 배열 생성
        arr = generateArray(from, to);

        // 배열 출력
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    // 사용자로부터 입력 받은 두 정수 사이의 수로 구성된 배열 생성 메소드
    public int[] generateArray(int from, int to) {
        // 배열 생성
        int[] arr = new int[to - from + 1];

        // 배열 초기화
        int value = from;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = value++;
        }

        // 배열 리턴
        return arr;
    }

}
