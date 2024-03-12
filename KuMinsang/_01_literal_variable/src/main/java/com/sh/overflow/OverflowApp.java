package com.sh.overflow;

/**
 * overflow
 * - 자료형별로 표현할수 있는 최대값을 벗어나는 현상
 * - 최대값을 벗어나면 최소값으로 처리된다
 * - 언더플로우 발생시 최대값으로 처리된다
 * - 이 동작을 정수 순환 이라고 부른다
 */

public class OverflowApp {
    public static void main(String[] args){
        int i = Integer.MAX_VALUE;
        System.out.println("Integer Max value = "+ i);
        System.out.println("Integer Max value + 1 = "+ ++i);
        System.out.println("Integer MIN value + 1 = "+ ++i);

        int j = Integer.MIN_VALUE;
        j = j -1;
        System.out.println(j); //
    }
}
