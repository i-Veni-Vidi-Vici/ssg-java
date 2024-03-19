package com.sh.array.copy;

import java.util.Scanner;

/**
 * 얕은 복사
 * - 배열 객체의 주소값을 복사
 * - 동일한 배열을 공유
 */
public class ShallowCopy {
    public void test1(){
        int[] arr = {1,2,3,4,5};
        int[] arr2 = arr;
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());
    }
    /**
     * 얕은 복사 활용 1: 매개인자
     */

    public void test2(){
        int[] arr = {1,2,3};
        System.out.println(arr.hashCode());
        print(arr);

    }
    public void print(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n"+ arr.hashCode());
    }

    /**
     * 얕은 복사 활용 - 리턴값
     */
    public void test3(){
        String[] animals = getAnimalArray();
        for(int i =0; i<3; i++)
            System.out.println(animals[i]);
        System.out.println("test3 Hash : " + animals.hashCode());

    }
    public String[] getAnimalArray(){
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        System.out.println("getanimal Hash : " + animals.hashCode());
        return animals;
    }

    /*
    사용자로부터 두 정수를 입력받아
    두 정수 사이의 수로 구성된 배열을 생성하라
    이때 배열 생성 메소드 generateArry(form:int, to:int)를 사용하세요
     */
    public void test4(){
        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 정수를 입력하세요 : ");
        int num1 = sc.nextInt();
        System.out.print("두번째 정수를 입력하세요 : ");
        int num2 = sc.nextInt();

        int[] result = generateArray(num1, num2);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
    public int[] generateArray(int num1, int num2){
        int size = num2 - num1+1;
        int[] result = new int[size];
        for(int i=0; i<size; i++){
            result[i] = num1+i;
        }
        return result;
    }



}
