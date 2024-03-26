package com.sh.array.copy;

import java.util.Scanner;

/**
 * 얕은 복사
 * - 배열객체의 주소값을 복사
 * - 동일한 배열을 공유
 */
public class ShallowCopy {
    public void test1(){
        int[] arr = {1,2,3,4,5};
        // 얕은 복사
        int[] arr2=arr; //arr의 주소값을 arr2에 대입

        //hashCode비교
        System.out.println(arr.hashCode()); //2055281021
        System.out.println(arr2.hashCode()); //2055281021

        // 값 확인
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr1[%d] = %d\n",i,arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr2[%d] = %d\n",i,arr[i]);
        }

        // 값 변경
        arr[1] *=10;
    }

    /**
     * 얕은 복사 활용 1: 매개인자
     */
    public void test2(){
        int[] arr = {1,2,3};
        System.out.println("test2 : " + arr.hashCode()); //2055281021
        print(arr);
    }

    public void print(int[] arr){
        System.out.println("test2 : " + arr.hashCode()); //2055281021 t
        //test2메서드의 array와 print메서드의 매개변수 arr는 같은 객체이다.
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2- 리턴값
     */

    public void test3(){
        String[] animals = getAnimalArray();
        System.out.println("test3 : " + animals.hashCode());
        for(int i=0;i<animals.length;i++){
            System.out.println(animals[i]);
        }
    }

    public String[] getAnimalArray(){
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        System.out.println("getAnimalArray : " + animals.hashCode());
        return animals;
    }

    /**
     * 사용자로부터 두 정수를 입력받아 두 정수 사이의 수로 구성된 배열을 생성/출력 하세요.
     * 이때 배열 생성메소드 generateArray(from: int, to:int)를 사용하세요/
     */
    public void test4(){
        Scanner sc = new Scanner(System.in);
        System.out.print("첫번째 정수 입력 : ");
        int start = sc.nextInt();
        System.out.print("두번째 정수 입력 : ");
        int end = sc.nextInt();

        // 배열생성
        int[] arr = generateArray(start,end);
        // 배열 출력
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public int[] generateArray(int from,int to){
        int len = to-from+1;
        int[] arr = new int[len];

        for(int i=0,value=from;i< arr.length;i++,value++){
            arr[i] = value;
        }
        return arr;
    }

//    private int[] generateArray(int from, int to) {
//        int[] arr = new int[to-from+1];
//        int value=from;
//
//        for(int i=0;i<to-from+1;i++){
//            arr[i] += value++;
//        }
//        return arr;
//    }
}
