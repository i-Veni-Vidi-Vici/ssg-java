package com.sh.polymorphism._01.casting;

import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {

        /**
         * 입력된 숫자를 역순으로 저장하시오
         * ex)1234-> 4321, 654879->978456, 321634->346123
         */

        Scanner sc=new Scanner(System.in);
        int num;
        int reverse=0;

        System.out.printf("역순 할 숫자를 적어주세요 : ");
        num=sc.nextInt();

        while(true)
        {
            reverse+=num%10;
            num=num/10;
            if(num==0)
                break;
            reverse*=10;

        }
        System.out.printf("역순된 숫자 : %d",reverse);
    }

}
