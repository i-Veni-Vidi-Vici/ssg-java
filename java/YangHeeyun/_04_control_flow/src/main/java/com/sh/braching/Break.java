package com.sh.braching;

/**
 * <pre>
 * break
 * - 반복문에서 break 실행되면 즉시 반복문 중지하고 탈출한다.
 * - 가장 인접한 반복문 블럭을 탈출.
 * - label(반복문이름)을 사용하면 해당 반복문 탈출 가능.
 * </pre>
 */
public class Break {
    /**
     * 무한반복문에서 특정 조건일때 탈출하도록 사용
     * 1~100까지의 합
     */
    public void test1() {
        int i=1;
        int sum=0;

        while(true){
            sum += i;
            System.out.println(i + " -> " + sum);
            if(i==100){
                break;
            }
            i++;
        }
    }

    /**
     * 중첩 반복문에서 break 사용하기
     */
    public void test2(){
        // 첫번째 for문의 abc라는 라벨(이름)을 붙여줬다.
        abc:
        for(int dan =2;dan < 10;dan++){
            for(int n=1;n<10;n++){
                if(dan*n>50){
                    break abc; //abc라는 라벨을 탈출한다. 안에 있더라도 맨 바깥쪽 for문을 탈출 할 수 있다.
                }
                System.out.printf("%d * %d = %d\n", dan, n, dan*n);
            }
        }
    }
}
