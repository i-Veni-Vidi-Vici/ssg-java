package com.ssg.test.array.copy;

import java.util.Scanner;

/**
 * 얕은 복사 = shllowcopy
 * - 배열객체의 주소값을 복사
 * - 동일한 배열을 공유
 */
public class ShallowCopy {
    public void test1() {
        int[] arr=new int[]{1,2,3,4,5};
        int[] arr2=arr;

        for(int i=0;i<5;i++)
        {
            System.out.printf(" %d ",arr[i]);
        }

        System.out.printf("\n");

        for(int i=0;i<5;i++)
        {
            System.out.printf(" %d ",arr[i]);
        }
    }

    /**
     * 얕은 복사 활용 1 : 매개인자
     */
    public void test2() {
        int[] arr={1,2,3};
        print(arr);
    }
    public void print(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.printf(" %d ",arr[i]);
        }
    }

    /**
     * 얀은 복사 활용2 - 리턴값
     */
    public void test3() {
        String[] animals=getAnimalArray();

        for(int i=0;i<animals.length;i++)
        {
            System.out.printf(" %s ",animals[i]);
        }

    }
    public String[] getAnimalArray(){
        String[] animals={"낙타","청개구리","나무늘보"};
        return animals;
    }

    /**
     * 사용자로 부터 두 정수를 입력받아 두 정수 사이의 수로 구성된 배열을 생성하세요
     * 이때 배열 생성메소드 generateArray(from : int, to:int)를 사용하세요
     */
    public void test4()
    {
        int start;
        int end;

        Scanner sc = new Scanner(System.in);

        System.out.printf("시작 숫자 : ");
        start=sc.nextInt();

        System.out.printf("마지막 숫자 : ");
        end=sc.nextInt();

        int[] arr=generateArray(start,end);

        for(int i=0;i<arr.length;i++)
        {
            System.out.printf("%d ",arr[i]);
        }
    }
    public int[] generateArray(int x, int y)
    {
        int[] arr=new int[y-x+1];

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=x++;
        }
        return arr;
    }
}