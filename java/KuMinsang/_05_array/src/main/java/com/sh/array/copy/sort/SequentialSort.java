package com.sh.array.copy.sort;


import static com.sh.array.copy.sort.Swap.swap;

/**
 * <pre>
 *     순차 정렬
 *     -회차에 해당하는 인덱스에 적절한 수를 찾는 방식
 * </pre>
 */
public class SequentialSort {
    public void test1(){
        int[] arr = {1,4, 5, 3, 2};
        for(int i =0 ; i<arr.length-1; i++){//회차의 각 자리마다 적절한 숫자를 찾음
            for(int j=i; j<arr.length; j++){    //각 회차마다 끝까지 비교
                if(arr[i]<arr[j])
                    swap(arr,i,j);
                Swap.print(arr,i);
            }
        }
    }
}
