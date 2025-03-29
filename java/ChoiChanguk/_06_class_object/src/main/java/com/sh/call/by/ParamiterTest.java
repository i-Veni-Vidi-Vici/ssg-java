package com.sh.call.by;


/**
 * <pre>
 * 가변인자
 *  - 동일한 타입의 매개인자를 개수 상관없이 전달하는 방식
 *  - 다른 매개변수와 섞어쓰는 경우 마지막에 한 번만 사용가능하다.
 * </pre>
 */
public class ParamiterTest {
    public static void main(String[] args) {
        System.out.println(sum(10,20));
        System.out.println(sum(30,40,50));
        System.out.println(sum(60,70,80,90));
        System.out.println(sum(100,110,120,130,140));
    }
    public void test(int n, String... str){}//가능
    //public test2(String... str, int n)//이건 불가능 str이 얼마나 올지 모르니깐
    //public test3(String... str, int... n)//한 번만 사용가능, 이건 안됨

    /**
     * int...nums
     * - 개수 제한없이 매개인자를 담을 수 있는 int[]이다.
     * @param nums
     * @return
     */
    public static int sum(int... nums)
    {
        int sum=0;
        System.out.println(nums.length);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
            sum+=nums[i];
        }
        System.out.print(sum+" ");
        return 0;
    }
}
