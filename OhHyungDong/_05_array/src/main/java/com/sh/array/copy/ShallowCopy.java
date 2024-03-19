package com.sh.array.copy;


import java.util.Scanner;

/**
 * 얕은 복사
 * - 배열객체의 주소 값을 복사
 * - 동일한 배열을 공유하게 됨. 주소값이 동일해서
 */
public class ShallowCopy {
    public void test()
    {
        int[] arr = {1, 2, 3, 4, 5};
        //얕은 복사
        int[] arr2 = arr; //arr의 주소값을 arr2에 대입.

        //hashoCode
        System.out.println(arr.hashCode());
        System.out.println(arr2.hashCode());

        //값 확인
        for(int i = 0; i<arr.length; i++){
            System.out.printf("arr[%d] = %d\n", i , arr[i]);
        }

        for(int i = 0; i<arr2.length; i++){
            System.out.printf("arr2[%d] = %d\n", i , arr[i]);
        }

        //값 변경 - 같은 객체를 공유하기 때문에 arr의 값을 변경시켜도 arr2의 값도 변경된다.
        arr[1] *= 10 ;
    }

    /**
     * 얕은 복사 활용 1 : 매개 인자
     *
     */
    public void test2()
    {
        int[] arr  = {1,2,3};
        System.out.println(arr.hashCode());
        print(arr);
    }

    public void print(int[] arr)// 매개 변수를 통해서 주소값이 복사됨 .
    {
        System.out.println(arr.hashCode());
        for(int i = 0; i< arr.length; i++)
        {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 얕은 복사 활용2  - 리턴 값
     */
    public void test3()
    {
        String[] animals = getAnimalArray();
        System.out.println("test3 : " + animals.hashCode());

        for(int i = 0; i<animals.length; i++)
        {
            System.out.println( animals[i]);
        }
    }

    public String[] getAnimalArray()
    {
        String[] animals = {"낙타", "청개구리", " 나무늘보"};
        System.out.println("getAnmima" + animals.hashCode());
        return animals;

    }

    /**
     * 사용자로부터 두 정수를 입력받아 두 정수 사이의 수로 구성된 배열을 생성하시오 .
     * 이때 배열 생성 메소드 generate
     */

    public void test4()
    {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int[] answer = generateArray(num1,num2);

        for(int i =0; i<answer.length; i++)
        {
            System.out.print(answer[i] + " ");
        }

    }

    public int[] generateArray(int from, int to){
        int k = (to-from) + 1;
        int [] answer = new int[k];
        //from : 4 to : 6 => 4 5 6 a[0] = 4 a[1] = 5 a[2] = 6

        for(int i = 0 ;i<answer.length; i++)
        {
            answer[i] = from++;
        }
        return answer;

    }

}
