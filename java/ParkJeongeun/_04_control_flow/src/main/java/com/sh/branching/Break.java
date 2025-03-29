package com.sh.branching;

/**
 * <pre>
 * break
 * - 반복문에서 break가 실행되면 즉시 반복문 중지하고 탈출
 * - 가장 인접한 반복문 블럭을 탈출 (inner에서 break 하면 outer로 나감, outer 밖으로 탈출X)
 * - label(반복문이름)을 사용하면 해당 반복문 탈출 가능 (반복문 위에 "이름:"형식으로 작성)
 * </pre>
 */

public class Break {
    /**
     * 무한반복문에서 특정조건일때 탈출하도록 사용
     * 1 ~ 100까지의 합
     */
    public void test() {
       int sum = 0;
       int i = 1;
       while (true){
           sum += i;
           System.out.println(i + " -> " + sum);
           if (i == 100){
               break;
           }
           i++;
       }
    }

    /**
     * 중첩반복문에서 break 사용하기
     * - 구구단 결과값이 50이 넘으면 구구단 정지
     */
    public void test2(){
        abc:
        for(int dan = 2; dan < 10; dan++) {
            for (int n = 1; n < 10; n++) {
                if (dan * n > 50){
                    break abc;
                }
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
        }
    }
}
