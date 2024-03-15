package com.sh.loop.test.loop;

public class Test7 {
    public static void main(String[] args) {
        for(int i=0;i<9;i++)
        {
            for(int j=i;j<8;j++)//이건 공백 for문
            {
                System.out.printf(" ");
            }


            for(int k=0;k<=i;k++)//1x8 숫자표현
            {
                System.out.printf("%d",k+1);
            }

            System.out.printf(" x 8 + %d = ",i+1);

            for(int j=0;j<=i;j++)//1=9부터 표현
            {
                System.out.printf("%d",9-j);
            }

            System.out.printf("\n");
        }
    }
}
