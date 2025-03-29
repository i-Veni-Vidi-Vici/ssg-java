package com.sh.branching;

/**
 * <pre>
 * break
 * - 반복문에서 break가 실행되면 즉시 반복문을 중지하고 탈출한다.
 * - 가장 인접한 반복문 블럭을 탈출.
 * - label(반복문 이름)을 사용하면 해당 반복문 탈출 가능.
 * </pre>
 */
public class Break {

    /**
     * 무한 반복문에서 특정 조건일때 탈출하도록 사용
     * 1 ~ 100 까지의 합
     */
    public void test1() {
        int i = 1, sum = 0;
        while (true) {
            sum += i;
            System.out.println(i + " -> " + sum);

            if (i == 100) {
                break;
            }
            i++;
        }
    }

    /**
     * 중첩반복문에서 break 사용하기
     * - 구구단 결과값이 50이 넘으면 구구단 아예 정지
     */
    public void test2() {
        abc:
        for (int dan = 1; dan < 10; dan++) {
            for (int n = 1; n < 10; n++) {
                int result = dan * n;
                if (result > 50) {
                    break abc;
                }
                System.out.printf("%d x %d = %d\n", dan, n, dan * n);
            }
        }

    }
}
