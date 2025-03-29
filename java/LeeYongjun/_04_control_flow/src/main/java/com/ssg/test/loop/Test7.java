package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9-i+1;j++)
            {
                System.out.print(" ");
            }

            for(int j=1;j<i+2;j++){
                System.out.printf("%d", j);
            }
            System.out.printf(" x 8 + %d = ",i+1);
            for(int m=9;m>9-i-1;m--)
            {
                System.out.printf("%d",m);
            }
            System.out.println( );
        }
    }
}
