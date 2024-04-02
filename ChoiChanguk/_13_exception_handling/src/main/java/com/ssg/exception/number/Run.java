package com.ssg.exception.number;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run=new Run();
        run.test1();
    }

    private void test1() {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        sc.nextLine();
        NumberProcess numberProcess=new NumberProcess();
        Boolean bool=numberProcess.checkDouble(a,b);
        if(bool)
        {
            System.out.printf("%d는 %d의 배수이다",b,a);
        }
        else System.out.printf("%d는 %d의 배수가 아니다",b,a);
    }

}
