package com.sh.array.copy;

import java.util.Scanner;

/**
 * 얕은 복사
 * - 배열 객체의 주소값을 복사
 * - 동일한 배열을 공유
 */

public class ShallowCopy {
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        // 얕은 복사
        int[] arr2 = arr; // arr의 주소값을 arr2에 대입

        // hashCode 비교
        System.out.println(arr.hashCode()); // 2055281021
        System.out.println(arr2.hashCode()); // 2055281021

        // 값 변경
        arr[1] *= 10; // arr2[1]도 동일하게 바뀜

        // 값 확인
        for(int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
        for(int i = 0; i < arr2.length; i++){
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    /**
     * 얕은 복사 활용1 : 매개인자
     */
    public void test2() {
        int[] arr = {1, 2, 3};
        System.out.println("test2 : " + arr.hashCode()); // 2055281021
        print(arr);
    }

    // 위에서 print 메소드 활용해서 arr 배열 호출 -> print 메소드에 arr 배열 얕은 복사
    public void print(int[] arr){
        System.out.println("print : " + arr.hashCode()); // 2055281021
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용 : 리턴값
     */
    public void test3() {
        String[] animals = getAnimalArray(); // 좌항 메소드를 호출해서 animals 배열에 대입
        for (int i = 0; i < animals.length; i++){
            System.out.println(animals[i]);
        }
    }

    public String[] getAnimalArray(){
        String[] animals = {"낙타", "청개구리", "나무늘보"};
        return animals;
    }

    /**
     * 사용자로부터 두 정수를 입력받아 두 정수 사이의 수로 구성된 배열 생성,출력
     * 이때 배열 생성 메소드 generateArray(from:int, to:int) 사용
     */
    public void test4() {
        //(나)
        int[] nums = generateArray();
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
//
        //(모범답안)
//        Scanner sc = new Scanner(System.in);
//        System.out.print("> 정수1을 입력하세요 : ");
//        int from = sc.nextInt();
//        System.out.print("> 정수2를 입력하세요 : ");
//        int to = sc.nextInt();
//        int[] arr = generateArray(from, to);
//        for (int i = 0; i <arr.length; i++){
//            System.out.print(arr[i] + " ");
//        }
    }
        //(나)
    public int[] generateArray() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 정수1을 입력하세요 : ");
        int num1 = sc.nextInt();
        System.out.print("> 정수2를 입력하세요 : ");
        int num2 = sc.nextInt();
        int diff = Math.abs(num1 - num2) + 1;
        int min = Math.min(num1, num2);
        int[] nums = new int[diff];
        for (int i = 0; i < diff; i++) {
            nums[i] = min++;
        }
        return nums;

        //(모범답안)
//    public int[] generateArray(int from, int to){
//            int len = to - from + 1;
//            int[] arr = new int[len];
//            for (int i = 0, int value = from; i < arr.length; i++, value++) {
//                arr[i] = value++;
//            }
//            return arr;
//    }
    }
}
