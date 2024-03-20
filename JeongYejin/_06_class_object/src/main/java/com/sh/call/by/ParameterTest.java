package com.sh.call.by;

/**
 * <pre>
 * 가변인자
 * - 동일한 타입의 매개인자를 개수 상관없이 전달하는 방식
 * - 다른 매개변수와 섞어쓰는 경우 마지막에 한번만 사용가능하다.
 * </pre>
 */
public class ParameterTest {
    public static void main(String[] args) {
        System.out.println(sum(10, 20));
        System.out.println(sum(30, 40, 50));
        System.out.println(sum(60, 70, 80, 90, 100));
    }

    public void test(int n, String... strs) {}
//    public void test2(String... strs, int n) {} // (X) 마지막에 작성해야 함.
//    public void test2(String... strs, int... n) {} // (X) 한번만 사용가능

//    public static int sum(int a, int b) {
//        return a + b;
//    }
//    public static int sum(int a, int b, int c) {
//        return a + b + c;
//    }
//    public static int sum(int a, int b, int c, int d, int e) {
//        return a + b + c + d + e;
//    }

    /**
     * int... nums
     * - 개수 제한없이 매개인자를 담을 수 있는 int[]이다.
     * @param nums
     * @return
     */
    public static int sum(int... nums) { // 우선순위가 높음
        System.out.println(nums.length);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
            sum += nums[i];
        }
        return sum;
    }
}