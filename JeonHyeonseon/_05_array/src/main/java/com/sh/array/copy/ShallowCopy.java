package com.sh.array.copy;

import java.util.Scanner;

/**
 * 얕은 복사(shallow copy)
 * - 배열객체의 주소값을 복사한 것이다.
 * - 동일한 배열을 공유하게 된다.
 */

public class ShallowCopy {
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5};
        // 얕은 복사
        int[] arr2 = arr; // arr의 주소값을 arr2에 대입

        // hashCode 비교
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        // 값변경
        arr[1] *= 10;

        // 값 확인
        for(int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
        for(int i = 0; i < arr2.length; i++) {
            System.out.printf("arr2[%d] = %d\n", i, arr[i]);
        }

    }

    /**
     * 얕은 복사 활용1 : 매개인자
     */
    public void test2(){
        int[] arr = {1, 2, 3};
        System.out.println("test2 : " + arr.hashCode());
        print(arr);
    }

    public void print(int[] arr) {
        System.out.println("print : " + arr.hashCode());
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2 - 리턴값
     */
    public void test3() {
        String[] animals = getAimalArray();
        System.out.println("test3 : " + animals.hashCode());
        for(int i = 0; i < animals.length; i++){
            System.out.println(animals[i]);
        }
    }

    public String[] getAimalArray() {
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        System.out.println("getAnimalArray : " + animals.hashCode());
        return animals;
    }

    /**
     * "사용자로부터 두 정수를 입력"받아, "두 정수 사이의 수"로 구성된 "배열"을 "생성/출력"하세요.
     * 이때 "배열 생성메소드" generateArray(from : int, to : int)를 사용하세요.
     */

//    public void test4() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("첫번째 정수 입력 : ");
//        int from = sc.nextInt();
//        System.out.println("두번째 정수 입력 : ");
//        int to = sc.nextInt();
        // 배열생성
//        int[] arr = generateArray(from, to);
        // 배열 출력
//        for(int i = 0; i < arr.length; i++)
//            System.out.println(arr[i] + " ");
//        }
//    }
//
//    public String[] generateArray(int from, int to) {
//       int len = to - from + 1;
//       int[] arr = new int[len];
//       int value = from;
//       for(int i = 0; i < arr.length; i++) {
//           arr[i] = value++;
//    }
//       return arr;
}
