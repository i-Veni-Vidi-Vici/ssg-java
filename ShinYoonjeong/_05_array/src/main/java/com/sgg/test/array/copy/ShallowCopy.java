package com.sgg.test.array.copy;

import java.util.Scanner; /**
 * 얕은 복사
 * - 배열객체의 주소값을 복사
 * - 동일한 배열을 공유
 */

public class ShallowCopy {
    public void test1(){
        int[] arr = {1, 2, 3, 4, 5};
        // 얕은 복사
        int[] arr2 = arr; // arr의 주소값을 arr2에 대입

        //hashCode 비교
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        // 값 변경
        arr[1] *= 10;

        // 값 확인
        for(int i = 0; i<arr.length;i++)
        {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
        for(int i = 0; i<arr2.length;i++)
        {
            System.out.printf("arr2[%d] = %d\n", i, arr[i]);
        }
    }
    public void test2(){
        int[] arr = {1,2,3};
        System.out.println("test2 : " + arr.hashCode());
        print(arr);
    }
    public void print(int[] arr){
        System.out.println("print : " + arr.hashCode());
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2 - 리턴값
     */
    public void test3(){
        String[] animals = getAnimalArray();
        for(int i=0;i< animals.length;i++)
        {
            System.out.println(animals[i]);
        }
    }
    public String[] getAnimalArray(){
        String[] animals = {"낙타", "청개구리","나무늘보"};
        System.out.println("getAnimalArray : " + animals.hashCode());
        return animals;
    }

    /**
     * 사용자로부터 두 정수를 입력받아 두 정수 사이의 수로 구성된 배열을 생성하세요.
     * 이때 배열 생성메소드 generateArray(from:int, to:int)를 사용하세요.
     */
    public void test4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 1 입력");
        int num1 = sc.nextInt();
        System.out.println("숫자 2 입력");
        int num2 = sc.nextInt();
        int[] arr = generateArray(num1, num2);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public int[] generateArray(int num1, int num2){
        int[] arr = new int[num2-num1+1];
        int start = num1;
        for(int i =0;i<arr.length;i++){
            arr[i]=start++;
        }
        return arr;
}



}