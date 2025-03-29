package com.sh.test.array;

/**
 * 길이가 100인 배열을 선언하고 1부터 100까지의 값을 순서대로 배열 인덱스에 넣어 그 값을 출력하는 코드를 작성하시오.
 */
public class Test1 {
    public static void main(String[] args){
        Test1 t = new Test1();
        t.test();
    }

    public void test(){
        int[] arr = new int[100];

        System.out.print("arr = {");
        for(int i=0;i<100;i++){
            arr[i] = i+1;
            if(arr[i] == 100){
                System.out.print(arr[i]);
                System.out.print("}");
                break;
            }
            System.out.print(arr[i]+", ");
        }
    }

}


