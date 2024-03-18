package com.sh.array.copy.sort;

import java.util.Arrays;

import static com.sh.array.copy.sort.Swap.print;

/**
 * <pre>
 *     삽입정렬
 *     - 정렬된 배열에 새로운 요소를 끼워넣음
 *     - 정렬이 되어 있지 않다면 [1]부터 시작하여 [0]과 비교하여 부분 정렬을 만들어간다
 *     - key==arr[i] 값을 임시 저장소에 저장한 후 [i]->[i-1] -> [1] -> [0] 순으로 비교해가며 tmp에 저장해둔 key 값이 들어갈 자리를 탐색한다
 *     - 이때 매회 탐색마다 key<[n]이면 배열 값을 한칸씩 옮겨 저장하여 key를 삽입할 빈공간을 만든다
 *     - 탐색이 끝나면 key값을 삽입하고 [i+1]을 key값으로 설정하여 다음 요소를 정렬한다
 *      O(n^2)를 따르며  최선의 경우 O(n)이다
 * </pre>
 *
 */
public class InsertionSort {
    public void test(){
        int[] arr= {5,2,6,4,1};
        for(int i=1; i<arr.length; i++){
            int tmp = arr[i];
            int j;
            for(j=i; j>0; j--){ //정렬할 값 [arr]==tmp의 위치를 찾는다
                //j-1 인덱스 값이 tmp보다 크다면 j-1인덱스의 값을 j인덱스에 덮어씌움
                if(arr[j-1]>tmp){
                    arr[j]= arr[j-1];
                    print(arr,i);
                }else{
                    //j-1 인덱스 값이 tmp보다 작다면 반복문 중지
                    //tmp를 넣을 자리를 찾았음
                    print(arr,i);
                    break;
                }
            }
            arr[j]=tmp; //값 삽입
        }
        System.out.println(Arrays.toString(arr));

    }
}
