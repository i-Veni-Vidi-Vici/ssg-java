package com.sh.call.by;
/**
 * <pre>
 *     가변인자
 *     -동일한 타입의 매개인자를 갯수 상관 없이 전달하는 방식
 *     -
 * </pre>
 */
public class ParameterTest {
    public static void main(String[] args){
        System.out.println(sum(10,20));
        System.out.println(sum(30,40,50));
        System.out.println(sum(60,70,80,90,100));
    }

    /**
     * int...nums
     * - 갯수 제한 없이 매개인자를 담을수 있는 int[] 이다
     * - 다른 매개변수와 섞어 쓰는 경우 마지막에 한번만 사용할수 있다
     * public void test2(String... str, int n){} //불가
     * public void test2(String... str, int... n){} //불가
     * 예시) printf(String , object...) 문자열에 들어갈 매개변수를 가변으로 여러개 받을수 있다
     *
     * @param nums
     * @return
     */
    public static int sum(int... nums){
        int sum=0;
        for(int i : nums){
            sum+=i;
        }
        return sum;
    }
}
