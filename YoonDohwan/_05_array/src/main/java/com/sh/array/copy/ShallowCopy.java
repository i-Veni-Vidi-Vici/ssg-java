package com.sh.array.copy;

import java.util.Scanner;

/**
 * 배열복사
 * (모든 객체에 해당되는 사항)
 * -얕은 복사 : 주소값만 복사해서 heap 영역의 같은 객체를 공유
 * -깊은 복사 : heap영역의 값이 동일한 객체를 복사. 같은 객체를 공유하지 않음.
 */

public class ShallowCopy {
    public void test1() {
        int[] arr= {1,2,3,4,5};
        //얕은복사
        int []arr2 = arr; //arr의 주소값을 arr2에 대입
        //해쉬코드 비교
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());
        //값확인
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n ",i,arr[i]);
        }
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr2[%d]=%d\n ",i,arr2[i]);
        }


    }
    //얕은 복사 활용 : 매개인자
    public void test2(){
        int[] arr={1,2,3};
        print(arr);
    }
    public void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }
    //얕은 복사 활용 : 리턴값
    public void test3(){
        String[] animals = getAnimalArray();
        for(int i=0;i< animals.length;i++){
            System.out.println(animals[i]);
        }

    }
    public String[] getAnimalArray(){
        String[] animals = {"낙타","청개구리","나무늘보"};
        return animals;
    }
    //사용자로 부터 두 정수를 입력받아 두정수 사이의 수로 구성된 배열을 생성하세요.
    //이때 배열 생성메소드 generateArray(from:int, to: int)를 사용하세요.
    public void test4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("2개의 정수를 입력하세요 : ");
        int from=sc.nextInt();
        System.out.println("2번째 정수 입력 : ");
        int to = sc.nextInt();
        int [] arr=generateArray(from, to);
        for (int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }

    private int[] generateArray(int from,int to) {

        int len = to - from +1;
        int[] arr =new int[len];
        int value = from;
        for(int i=0;i<arr.length;i++){
            arr[i]=value++;
        }
        return arr;
    }


}

