package com.sh.branching;


/**
 * break
 * - 반복문에서 break가 실행되면 즉시 반복문을 중지하고 탈출한다.
 * - 반복문 블럭을 탈출
 */
public class Break {
    /**
     * 무한반복문에서 특정 조건일 때 탈출하도록 사용
     */

    //1~100까지 합
    public void test1(){
        int i =1;
        int sum =0;
        while (true){
            if(i>100)break;
            sum+=i;
            i++;
        }
    }

    /**
     * 중첩문에서 break 사용
     */
    public void test2(){
        dan: for(int dan=2; dan<10; dan++){
            for(int n =1; n<10; n++){
                if(dan*n>50) break dan;
                System.out.printf("%d * %d = %d\n", dan, n, dan*n);
            }
        }
    }
}
