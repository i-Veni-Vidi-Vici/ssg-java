package com.sh.branching;

/**
 * <pre>
 *  break
 *  - 반복문에서 break가 실행되면 즉시 반복문을 중지하고 탈출한다.
 *  - 가장 인접한 반복문 블럭을 탈출한다는 의미
 *  - label(반복문의 이름)을 사용하면 해당 반복문 탈출도 가능하다
 *
 * </pre>
 */

public class Break {
    /**
     * 무한반복문에서 특정조건일때 탈출하도록 사용
     * 1 ~ 100까지의 합
     */
    public void test1() {
        int sum = 0;
        int i = 1;
        while(true) {
            sum += 1;
            System.out.println(i + " -> " + sum);
            if(i == 100) {
                break;
            }
            i++;
        }
    }

    /**
     * 중첩반복문에서 break 사용하기
     * - 구구단 결과값이 50이 넘으면 구구단을 정지하기
     */
    public void test2() {
        abc: // 바깥 반복문의 이름을 의미한다.
        for(int dan = 2; dan < 10; dan++) {
            for(int n = 1; n < 10; n++){
                if(dan * n > 50){
                    break abc; //안에 있는 반복문 안에 break가 있지만 abc가 있으므로 바깥 반복문까지 break가 가능하다.
                }
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
        }
    }
}
