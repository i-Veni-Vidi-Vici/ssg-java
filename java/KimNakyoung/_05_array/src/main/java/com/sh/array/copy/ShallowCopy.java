package com.sh.array.copy;

import java.util.Scanner;

/**
 * 얕은 복사
 * - 배열객체의 주솟값을 복사
 * - 동일한 배열을 공유
 */


public class ShallowCopy {

    public void test1(){
        int[] arr = {1, 2, 3, 4, 5}; // 힙영역에 배열객체 생성
        // 얕은 복사
        int[] arr2 = arr; // arr의 주솟값을 arr2에 대입

        //hashCode 비교
        System.out.println(arr.hashCode()); // 2055281021
        System.out.println(arr2.hashCode()); // 2055281021

        // 값 변경
        arr[1] *= 10; // 같은 주솟값 공유 하기 때문에  한 곳이 바뀌면 다 바뀜


        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i , arr[i]); // 각 자릿수에 동일한 값 가지고 있음
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.printf("arr2[%d] = %d\n", i , arr[i]);
        }

    }

    /**
     *
     * 얕은 복수 활요 1. : 매개인자
     *
     */

    public void test2(){
        int[] arr = {1,2,3};
        print(arr); // 얕은복사!
        System.out.println(arr.hashCode());
        print(arr);

    }
    // int[] arr 매개변수 넣을 공간
    // int[] arr2 = arr; // arr의 주솟값을 arr2에 대입
    public void print(int[] arr){
        System.out.println("print : " + arr.hashCode());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2 - 리턴값
     *
     */


    public void test3(){
        String[] animals = getAnimalArray();
        System.out.println("animal : " + animals.hashCode());

        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]); // 배열 안에 있는 모든 값 출력
        }

    }

    public String[] getAnimalArray() {
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        System.out.println("getAnimalArray : " + animals.hashCode());
        return animals;
    }


    /**
     * 사용자로 부터 두 정수를 입력받아 두정수 사이의 수로 구성된 배열을 생성/출력하세요.
     * 이때 배열 생성메소드 generateArray(from:int, to:int)를 사용하세요.
     */

    public void test4(){
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수1 입력 : ");
        int from = sc.nextInt();
        //배열 생성
        System.out.print("> 정수2 입력 : ");
        int to = sc.nextInt();
        //배열 출력
        int[] arr = generateArray(from,to); // 여기로 그대로 주솟값 복사

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " "); // 배열 안에 있는 모든 값 출력
        }
    }

    public int[] generateArray(int from , int to){
        int len = to - from + 1 ;
        int arr[] = new int[len]; // 두정수 사이의 수로 구성된 배열 생성
        int value = from; // 시작
        for (int i = 0; i < arr.length; i++) {
            arr[i] = value++; // 배열의 길이까지 증가
        }
        return arr; // 리턴하면
    }

}
