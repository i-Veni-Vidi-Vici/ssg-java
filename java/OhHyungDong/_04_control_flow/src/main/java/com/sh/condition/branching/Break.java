package com.sh.condition.branching;

/**
 * <pre>
 *  break
 *  - 반복문에서 break 실행되면 즉시 반복문을 중지하고 탈출한다.
 *  - 반복문 인접한 블럭을 탈출.
 *  - label(반복문 이름)을 사용하면 해당 반복문 탈출 가능.
 * </pre>
 */
public class Break {
    /**
     * 무한 반복문에서 특정조건 일 때 탈출하도록 사용
     * 1-100까지의 합
     */
    public void test()
    {
        int sum = 0;
        int i = 1;
        while(true){
            sum += i;
            System.out.println(i + " : " + sum);
            if(i == 100) break;
            i++;
        }
    }

    /**
     * 중첩 반복문에서 break 사용
     * - 구구단 결과값이 50이 넘으면 구구단 정지
     */
    public void test2()
    {
        abc: //라벨
        for(int dan = 2; dan < 10; dan++)
        {
            for(int n = 1; n < 10; n++){
                System.out.printf("%d * %d = %d \n",dan,n,dan*n);
                if(dan * n > 50) break abc;
            }

        }
    }
}
