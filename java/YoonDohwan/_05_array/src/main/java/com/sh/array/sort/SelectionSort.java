package com.sh.array.sort;

import java.util.Arrays;

import static com.sh.array.sort.Swap.print;
import static com.sh.array.sort.Swap.swap.swap;

/**
 * 선택정렬
 * -각 회차에 최소값을 찾고, 회차 마지막에 1번만 값교환하는 방식
 * -순차정렬 대비 성능이 우수하다. (교환회수가 적용)
 */
public class SelectionSort {
    public void test() {
        int[] arr={5,4,1,3,2};
        for(int i=0;i<arr.length-1;i++){
            //i=0,1,2,3(마지막 자리는 비교하지 않음.)
            int min=i; //최소값을 가리키는 인덱스. 최초 i번지라고 설정
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;//이제 최소값은 j번지
                }
                print(arr,i);
            }
            swap(arr,i,min);
        }
        System.out.println(Arrays.toString(arr));
    }
}
