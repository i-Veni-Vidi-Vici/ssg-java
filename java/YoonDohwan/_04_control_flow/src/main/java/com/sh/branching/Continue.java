package com.sh.branching;

/**
 * continue
 * 반복문안에서 continue를 실행하면 즉시 해당 턴을 중지하고, 반복문을 다시 시작하다.
 * for문인 경우. 증감식으로 이동
 * while문인 경우 조건식으로 이동
 */
public class Continue {
    public void test1() {
      //for(int i=1;i<=20;i++){
        int i=0;
        //while문에 continue는 더욱 주의해야한다.
        //continue 하위에 증감식이 위치해서는 안된다.
        while(i<=20){
            i++;
            System.out.println("ㅇㅇ");
            if(i%2!=0){
                continue;
            }
            System.out.println(i);
        }
    }
    public void test2(){
        ss:
        for(int dan =2; dan<10;dan++){
            for(int n=1;n<10;n++){
                System.out.printf("%d * %d = %d\n",dan,n,dan*n);
                if (dan == n) {
                    continue ss;
                }
            }
        }
    }
}
