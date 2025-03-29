package com.sh._04.checked;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public void sum(){

        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        int sum;
        while(true)
        {
            try {
                System.out.printf("정수 a,b를 입력 해주세요 : ");
                a=sc.nextInt();
                b=sc.nextInt();
                sum=a+b;
                System.out.println("결과 : "+sum );
                return;
            }
            catch (InputMismatchException e)
            {
                System.out.println("유효한 정수를 입력해주세요");
                sc.nextLine();// b=sc.nextInt 후 return되면 끝인데
                //그게 아니라면 \n을 마지막으로 계속 개행이 들어가서 입력을 못한다
                //어?? 엔터가 들어왔는데?? 입력된거네?? 하고 계속 넘어간다
            }
        }
    }
}
