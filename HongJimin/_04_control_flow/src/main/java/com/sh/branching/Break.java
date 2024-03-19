package com.sh.branching;

/**
 * break
 * - 반복문에서 break 실행되면 즉시 반복문 중지하고 탈출한다.
 * - 가장 인접한 반복문 블럭을 탈출.
 * - label(반복문의 이름)을 사용하면 해당 반복문 탈출 가능
 */
public class Break {
    /**
     * 무한 반복문에서 특정 조건일 때 탈출하도록 사용
     * 1 ~ 100까지의 합
     */
    public void test1() {
        int sum = 0;
        int i = 1;
        while(true) {
            sum += i;
            System.out.println(i + " -> " + sum);
            if (i ==100) {
                break;
            }
            i ++;
        }
    }

    /**
     *  중첩반복문에서 break 사용하기
     *  - 구구단 결과값이 50이 넘으면 구구단을 정지하고 싶음!
     */
    public void test2() {
        abc: //
        for (int dan = 2; dan < 10; dan++) {
            for (int n = 1; n < 10; n++) {
                if(dan * n > 50) {
                    break abc;
                }
                System.out.printf("%d * %d = %d\n", dan, n, dan*n);
            }
        }
    }
}
