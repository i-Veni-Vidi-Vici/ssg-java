package com.sh.array.copy;


import java.util.Scanner;

/**
 * 얕은 복사 = ShalowCopy
 * - 배열 객체의 주소값을 복사
 * - 동일한 배열을 공유
 */
public class ShallowCopy {
    public void test1() {
        int[] arr = {1, 2, 3, 4, 5};
        //얕은 복사
        int[] arr2 = arr; // arr의 주소값을 arr2에 대입

        //hashCode 비교
        System.out.println(arr.hashCode()); //2055281021
        System.out.println(arr2.hashCode()); //2055281021

        //값 변경
        arr[1] *= 10;

        //값 확인
        for (int i = 0; i< arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
        for (int i = 0; i< arr.length; i++) {
            System.out.printf("arr2[%d] = %d\n", i, arr[i]);
        }
    }

    /**
     * 얕은 복사의 활용 1: 매개 인자
     */
    public void test2() {
        int[] arr = {1, 2, 3};
        System.out.println("test2 : " +arr.hashCode());
        print(arr);


    }
    public void print(int [] arr) {
        System.out.println("print : " + arr.hashCode());
        for (int i = 0; i<arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public void test3(){
        String [] animals = getAnimalArray();
        System.out.println("test 3 : " + animals.hashCode());

        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }
    }

    public String [] getAnimalArray() {
        String [] animals = {"낙타" +
                "청개구리" +
                "나무늘보"};
        return animals;
    }

    /**
     * 사용자로부터 두 정수를 이력받아 두 정수 사이의 수로 구성된 배열을 생성하세요/
     * 이때 배열 생성메소드  genearateArray(from : int, to : int )를 사용하세요
     */

}
