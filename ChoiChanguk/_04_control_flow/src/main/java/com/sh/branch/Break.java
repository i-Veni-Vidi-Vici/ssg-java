package com.sh.branch;

public class Break {
    /**
     * break
     * - 반복문에서 break 실행되면 즉시 반복문을 중지하고 탈출한다.
     * - 가장 인접한 반복문 블럭을 탈출
     * - label(반복문이름)을 사용하면 해당 반복문 탈출 가능.
     */
    public void test1() {
        /**
         * 1~100까지 합
         */
        int sum=0;
        int i=1;
        while(true)
        {
            sum=sum+i;
            i++;
            if(i==101)
                break;
        }
        System.out.print(sum);
    }

    public void test2() {
        /**
         * 중첩반복문에서 break 사용하기
         * 결과값이 50넘으면 구구단을 정지
         */
        abc:for(int dan=2;dan<10;dan++)
        {
            System.out.printf("%d단 입니다\n",dan);
            for(int n=1;n<10;n++)
            {
                if(dan*n>50) {
                    break abc;
                }
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
        }
    }
}
