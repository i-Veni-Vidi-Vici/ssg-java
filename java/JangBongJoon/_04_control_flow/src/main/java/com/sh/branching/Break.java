package com.sh.branching;


/*
break
반복문
 */
public class Break {
    //무한반복문에서 특정조건일때 탈출하도록 사용한다.
    void test1() {
        int sum = 0;
        int i = 1;
        while (true) {
            sum += i;
            System.out.println(i + " -> " +
                    sum);
            i++;
        }
    }
    /*
    중첩반복문에서 break 사용하기
    구구단 결과값이 50이 넘으면 구구단 정지
     */
    void test2() {
        abc:
        for (int dan = 2; dan < 10; dan++) {
            for (int n = 0; n < 10; n++) {
                if (dan * n > 50) {
                    break abc;
                }
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
        }
    }
}
