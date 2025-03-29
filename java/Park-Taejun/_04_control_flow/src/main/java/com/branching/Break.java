package com.branching;

public class Break {
    /**
     * 무한반복문에서 특정조건일때 탈출하도록 사용
     * 1 ~ 100 까지의 합
     * break
     * 반복문에서 break 실행되면 탈출
     * 가장 인접한 반복문에서 탈출함
     */

        public void test1(){
            int sum = 0;
            int i = 1;
            while (true){
                sum += i;
                System.out.println(i + " -> " + sum);
                if(i == 100){
                    break;
                }
                i++;


        }

    }

    /**
     * 중첩반복문에서 break 사용하기
     * 구구단 결과값이 50이 넘으면 구구단 정지
     */
    public void test2(){
        abc:
        for(int dan = 2; dan < 10; dan ++){
            for (int n = 1; n <10; n++){
                if(dan * n > 50){
                    break abc; // 반복문 이름을 찾아서 탈출해버린당
                }
                System.out.printf("%d * %d =%d\n", dan, n, dan*n);




            }
        }

    }
}
