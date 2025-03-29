package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        int total=0;
        int num=0;
        for(int i=1;i<10;i++){

            num=(num*10+i);
            total=num*8+i;
            for(int j=10;j>i;j--) {
                System.out.print(" ");
            }
           System.out.printf("%d*%d+%d=%d\n",num,8,i,total);







        }


    }
}
