package com.sh.branching;

/**
 * continue
 * - 반복문안에서 continue 를 실행하면, 즉시 해당 턴을 중지하고, 반복문을 다시 시작한다.
 * - for 문인 경우, 증감식으로 이동
 * - while 문인 경우, 조건식으로 이동
 */
public class Continue {
    // 짝수 출력 1~20
    public void test1() {
//        for (int i = 1; i <= 20; i++) {
//            if (i % 2 != 0) {
//                continue;
//            }
//            System.out.println(i);
//        }

        // continue 하위에 증감식이 위치해서는 안된다.
//        int i = 1;
//        while (i <= 20) {
//            if (i % 2 != 0) {
//                continue;
//            }
//            System.out.println(i);
//            i++;
//        }

        int i = 0;
        while (i <= 20) {
            i++;
            if (i % 2 != 0) {
                continue;
            }
            System.out.println(i);
        }
    }

    /**
     * 구구단 출력
     * - 각 단에서 dan 과 n의 값이 같을 때까지만 출력
     */
    public void test2() {
        abc:
        for (int dan = 2; dan < 10; dan++) {
            for (int n = 1; n < 10; n++) {
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
                if (dan == n) {
                    continue abc; // abc 반복문의 증감식으로 이동
                }
            }
        }
    }
}
