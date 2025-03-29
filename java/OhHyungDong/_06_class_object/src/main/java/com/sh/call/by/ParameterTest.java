package com.sh.call.by;

/**
 * <pre>
 *  가변인자
 *  - 동일한 타입의 매개인자를 개수 상관없이 전달하는 방식
 *  - 다른 매개변수와 섞어쓰는 경우 한번마 사용가능하다.
 *
 *
 * </pre>
 */
public class ParameterTest {
    public static void main(String[] args) {
        System.out.println(sum(10,20));
        System.out.println(sum(10,2,30));
        System.out.println(sum(10,20,30,40));

    }

    public void test(int n,String ... strs){}
   // public void test2(String... strs, int n){} 마지막에 작성
    //public void test(String... strs, int n){} // 한번만 사용 가능

    /**
     * int...nums
     * - 개수 제한 없이 매개인자를 담을 수 있는 int[]이다.
     * @param nums
     * @return
     */
    public static int sum(int...nums){
      //  System.out.println(nums.length);
        int sum = 0;
        for(int i = 0; i< nums.length;i++){
            //System.out.println(nums[i]);
            sum +=nums[i];
        }
        return 0;
    }
}
