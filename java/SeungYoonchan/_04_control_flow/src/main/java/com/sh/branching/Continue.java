package com.sh.branching;

/**
 * <pre>
 *     - 반복문 안에서 continue 를 실행하면 즉시 해당턴을 중지하고 반복문을 실행
 *     - for문인 경우 증감식으로 이동
 *     - while문인 경우 조건식으로 이동
 * </pre>
 */
public class Continue {
    public void test1() {
//        for (int i = 0; i <= 20; i++) {
//            if (i % 2 != 0) {
//                continue;
//            }
//            System.out.println(i);
//        }

        int i = 1;
        while (i <= 20) {
            i++;
            if (i % 2 != 0) {
                continue;
            }
            System.out.println(i);
        }
    }

    public void test2(){
        xyz:
        for(int dan = 2; dan<10; dan++){
            for (int n = 1; n < 10; n++) {
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
                if (dan == n) {
                    System.out.println();
                    continue xyz;
                }
            }
        }

    }


}
