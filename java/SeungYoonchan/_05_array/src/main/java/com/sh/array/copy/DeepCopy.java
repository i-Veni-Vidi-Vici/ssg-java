package com.sh.array.copy;

/**
 * <pre>
 *
 * </pre>
 */
public class DeepCopy {
    /**
     * <pre>
     *     직접 복제하기
     *     1. 동일한 크기의 배열 생성
     *     2. 인덱스별로 동일한 값 복사
     * </pre>
     */
    public void test1(){
        int[] arr = {10, 20, 30};
        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        print(arr);
        print(arr2);
    }

    /**
     * Object#clone()
     */
    public void test2(){
        int[] arr = {5, 6, 7};
        int[] arr2 = arr.clone();

        print(arr);
        print(arr2);
    }

    /**
     * System.arraycopy(src, srcPosition, dest, destPosition, length) : void
     * - src 배열의 srcPosition 인덱스부터 dest 배열의 destPosition 인덱스로 length개 복사
     */
    public void test3(){
        int[] arr = {10, 20, 30, 40, 50};
        int[] arr2 = new int[arr.length];

        System.arraycopy(arr,0,arr2,0,arr.length);

        print(arr);
        print(arr2);
    }

    public void test4(){}
    public void test5(){}
    public void test6(){
        int[][] arr = {
                {1,2,3,4,5},
                {11,12,13,14,15},
                {101,102,103,104,105}
        };
        for(int[] inner_arr: arr){
            for(int val : inner_arr){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    /**
     * 세 배열 a,b,c를 배열 d로 합치기
     */
    public void test7() {
        int[] a = {1, 2, 3};
        int[] b = {4, 5};
        int[] c = {6, 7, 8, 9, 10};
        int[] d = new int[10];

        int start = 0;
        System.arraycopy(a, 0, d, start, a.length);
        start += a.length; // 3
        System.arraycopy(b, 0, d, start, b.length);
        start += b.length;
        System.arraycopy(c, 0, d, start, c.length);

        print(d);

    }
    public void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }


}
