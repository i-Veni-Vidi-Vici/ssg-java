package com.sh.branching;

import java.awt.*;

/**
 * - 반목문에서 break 가 실행되면 즉시 반복문을 중지하고 탈출한다.
 */
public class Break {
    public void test1() {
        int sum = 0;
        int i = 1;
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
     */
    public void test2() {
        abc: // label
        for (int dan = 2; dan < 10; dan++) {
            for (int n = 1; n <= 9; n++) {
                if (dan * n > 50) {
                    break abc;
                }
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
        }
    }
}
