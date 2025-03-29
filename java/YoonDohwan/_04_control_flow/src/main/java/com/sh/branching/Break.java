package com.sh.branching;

/**
 * break
 * -반복문에서 break 실행되면 즉시 반복문 중지하고 탈출한다.
 * -가장 인접한 반복문 블럭을 탈출
 * -label(반복문의이름)을 사용하면 해당 반복문 탈출 가능.
 */
public class Break {
    /**
     * 무한반복문에서 특정조건일때 탈출하도록 사용
     */
    public void test1() {
        int i =1 ;
        int sum=0;
        while(true){
            sum +=i;
            System.out.println(sum);
            if(sum==100){
                break;

            }
            i++;
        }
    }
    public void test2(){
        abc:
        for(int dan=2;dan<10;dan++){
            for(int n=1;n<10;n++){
                if(dan*n>50) {
                break abc;
                }
                System.out.printf("%d *%d = %d\n",dan,n,dan*n);
            }
        }
    }
}
