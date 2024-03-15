package com.sh.branching;

/**
 * <pre>
 * break
 * - 반복문에서 break 실행되면 즉시 반복문 중지하고 탈출한다.
 * - 가장 인접한 반복문 블럭을 탈출.
 * </pre>
 */
public class Break {
    /**
     * 무한 반복문에서 특정 조건일때 탈출하도록 사용
     * 1 ~ 100까지의 합
     */
    public void test1() {
        int sum = 0;
        int i = 1;
        while (true) {
            sum += 1;
            System.out.println(i + " -> " + sum);
            if (i == 100) {
                break;
            }
            i++;
        }
    }
    public void test2() {

    }
}
