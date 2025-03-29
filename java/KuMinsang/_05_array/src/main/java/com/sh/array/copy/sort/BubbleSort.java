package com.sh.array.copy.sort;

import static com.sh.array.copy.sort.Swap.print;
import static com.sh.array.copy.sort.Swap.swap;

/**
 * <pre>
 *     버블정렬
 *     -인접한 두개의 요소를 검사해 정렬하는 방식
 *     -구현은 쉬우나, 정렬속도는 빠르지 않다
 *     -이미 정렬된 데이터를 다시 정렬하는 경우 유용하다.
 *     -바깥 반복문은 인데긋가 아닌 반복 횟수를 의미한다.
 *     -한 회차에 오른쪽부터 정렬이 완성된다
 * </pre>
 */
public class BubbleSort {
    public void test(){
        int[] arr = {5, 3,4,1,2};
        //n-1회 정렬한다

        for(int i = arr.length-1; i>0; i--){
            //i=4 j=0,1,2,3
            //i=3 j=0,1,2
            //i=2 j=0,1
            for(int j =0; j<i; j++){
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
                print(arr,i);
            }
        }
    }
}
