package com.sh.call.by;

/**
 * 가변인자
 * - 동일한 타입의 매개인자를 개수 상관 없이 전달하는 방식
 * - 다른 매개변수와 섞어 쓰는 경우 마지막에만 한번 사용 가능하다.
 */
public class ParameterTest {
    public static void main(String[] args) {
        System.out.println(sum(10, 20));
        System.out.println(sum(10, 20, 30));
        System.out.println(sum(10, 20, 30, 40));
    }

    /**
     * int... nums
     * - 개수 제한 없이 매개 인자를 담을 수 있는 int[]이다.
     */
    public static int sum(int... nums) {
        //System.out.println(nums.length);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // System.out.println(nums[i]);
        }
        return sum;
    }

    public void test1(int n, String... str) { }
    // public void test1(String... str, int n) { } // 마지막에 사용해야함
    // public void test1(String... str, int... n) { } // 한번만 사용 가능
}
