package com.sh.branch;

/**
 * continue
 * - 반복문안에서 continue를 실행하면, 즉시 해당 턴을 중지하고, 반복문을 다시 시작한다.
 * - for문인 경우, 증감식으로 디오
 * - while문인 경우 조건식으로 이동
 */
public class Continue {
    public void test1() {
        /**
         * 1~20사이 짝수 출력
         */
//        int i;
//        for(i=1;i<=20;i++)
//        {
//            if(i%2!=0) {
//                continue;
//            }
//            System.out.printf("%d \n",i);
//        }

        //while문에서 continue는 더욱 주의해야 한다.
        // continue하위에 증감식이 위치해서는 안된다.
        int i=1;
        while(i<=20){
            i++;
            if(i%2!=0)
                continue;
            System.out.printf("%d \n",i);

        }
    }
    public void test2() {
        /**
         * 구구단 출력하는데,
         * - 각단에서 dan과 n의 값이 같을 때 까지 출력
         */
        int dan;
        int n;
        a:for(dan=2;dan<10; dan++){
            System.out.printf("%d 단입니다\n",dan);
            for (n = 1; n < 10; n++) {
                System.out.printf("%d * %d = %d\n",dan, n, dan*n);
                if(dan==n) {
                    continue a;
                }


            }
        }

    }
}
