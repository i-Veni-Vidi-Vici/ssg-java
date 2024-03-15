package com.sh.branching;

/*
continue
반복문안에서 continue를 실행하면 즉시 해당 턴을 중지하고 반복문을 다시 시작한다.
for문인 경우 증감식으로 이동
whilea문인 경우, 조건식으로 이동
 */

public class Continue {
    /*
    1~20 사이의 짝수 출력하기
     */
    void test1() {
        for (int i = 0; i <= 20; i++) {
            System.out.println(i);
        }
    }
/*
구구단 출력
각단에서 dan과 n의 값이 같을때 까지만 출력
 */
    public void test2() {
        xyz:
        for (int dan = 2; dan < 10; dan++) {
            for (int n = 1; n < 10; n++) {
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
                if (dan == n) {
                    continue xyz; //xyz반복문의 증감식으로 이
                }
            }
        }
    }
}
