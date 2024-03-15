package com.sh.branching;

/**
 * <pre>
 * continue
 * - 반복문안에서 continue를 실행하면, 즉시 해당 턴을 중지하고, 반복문을 다시 시작한다.
 * - for문인 경우, 증감식으로 이동
 * - while문인 경우, 조건식으로 이동
 * </pre>
 */

public class Continue {

    /**
     * 1 ~ 20 사이의 짝수 출력하기
     */
    public void test1() {

//        for(int i = 1; i <=20; i++){
//            if(i % 2 != 0) {// i가 홀수라면
//                continue; //continue가 실행되는 순간 for문인 경우 증감식(i++)으로 이동
//            }
//            System.out.println(i);
//        }
        // while문에 continue는 더욱 주의해야 한다.
        // continue하위에 증감식이 위치해서는 안된다.
//        int i = 1;
//        while(i <= 20){
//            if(i % 2 == 0){
//                continue;
//            }
//            System.out.println(i);
//            i++; // 이 증감식은 continue에서 실행되지도 않는다.
//        }

        // 참고하기. 이런 것들도 있다하고 넘어가기
        int i = 0;
        while (i <= 20) {
            i++;
            if (i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }

    /**
     구구단 출력
     * - 각 단에서 dan(단)과 n(수)의 값이 같을 때까지 출력
     */
    public void test2() {
        xyz:
        for(int dan = 2; dan < 10; dan++) {
            for(int n = 1; n < 10; n++) {
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
                if(dan == n) {
                    continue xyz; // xyz반복문의 증감식으로 이동한다.
                }
            }
        }
    }
}
