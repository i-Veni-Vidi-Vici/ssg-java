package com.ssg.test.lotto;

import java.util.Arrays;
import java.util.Random;
import static com.sh.array.copy.sort.Swap.swap;

public class LottoApp {
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] nums = new int[6];
        boolean flag;

        for(int i=0; i<6; i++){
            int tmp=0;
            flag = true;
            while(flag){
                tmp = rnd.nextInt(45)+1;
                flag = insertNum(nums, tmp);
            }
            nums[i]=tmp;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static boolean insertNum(int[] arr, int num){

        int k=0;
        while((arr[k] != num) && (arr.length>k)){
            if(arr[k]==num){
                return true;
            }else if(arr[k]==0){
                arr[k]=num;
                return false;
            }
            k++;
        }
        return false;
    }
}
