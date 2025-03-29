package com.sh.call.by;

public class ParameterTest {
    public static void main(String[] args) {
        System.out.println(sum(1,2));
        System.out.println(sum(10,20,30));
    }

    /**가변인자 호출
     *   - 개수 제한 없이 매개인자를 담을 수 있는 int[] 이다.
     */
    public static int sum(int... nums){
        int sum = 0;
        for(int i =0; i< nums.length; i++){
            sum+=nums[i];
        }
        return sum;
    }
}
