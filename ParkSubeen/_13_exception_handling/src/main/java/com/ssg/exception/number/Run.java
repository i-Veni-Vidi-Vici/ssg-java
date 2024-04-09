package com.ssg.exception.number;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.test();
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 첫번째 정수 입력 : ");
        int a = sc.nextInt();
        System.out.print("> 두번째 정수 입력 : ");
        int b = sc.nextInt();

        try{
            NumberProcess ns = new NumberProcess();
            boolean bool = ns.checkDouble(a, b);
            if(bool) {
                System.out.println(a + "의 배수이다.");
            }else {
                System.out.println(a + "의 배수가 아니다.");
            }
        }catch (NumberRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
