package com.sh.branching;

/**
 * <pre>
 * continue
 * - 반복문안에서 continue를 실행하면, 즉시 해당 턴 중지, 반복문 다시 시작
 * - for문인 경우, 증감식으로 이동
 * - while문인 경우, 조건식으로 이동
 * </pre>
 */
public class Continue {
    /**
     * 1 ~20사이의 짝수 출력하기
     */

    public void tset1() {
//        for (int i = 1; i <= 20 ; i++) {
//            if (i % 2 != 0) {
//                continue;
//            }
//            System.out.println(i);

        // while문에 continue는 더욱 조심해야함
        int i = 1;
        while (i <= 20) {
            System.out.println("😜");
            if (i % 2 != 0)
                continue;
            System.out.println(i);
            i++;
        }
    }


    /**
     * 구구단 출력
     * - 각단에서 dan과 n의 값이 같을때 까지 출력
     */
    public void test2() {
        xyz:
        for (int dan = 2; dan < 10; dan++) {
            for (int n = 1; n < 10; n++) {
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
                if (dan == n) {
                    continue xyz;
                }
            }
        }
    }
}

