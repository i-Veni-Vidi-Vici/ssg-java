package com.sh._02.exception.number;

import java.util.Scanner;

public class NumberProcess {

    public boolean checkDouble(int a, int b) {
        boolean ft = false;
        if(a % b == 0){
            ft = true;
        }else{
            ft = false;
        }
        if(!((a >= 1 && a <= 100) && (b >= 1 && b <=100))){
            throw new NumberRangeException("1부터 100사이의 값이 아닙니다.");
        }


        return ft;
    }

    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째수를 입력해주세요");
        int a = sc.nextInt();
        System.out.println("두번째수를 입력해주세요");
        int b = sc.nextInt();
        try {
            if (checkDouble(a,b) == true) {
                System.out.println(a + "는 " + b + "의 배수이다.");
            } else {
                System.out.println(a + "는 " + b + "의 배수가 아니다.");
            }
        } catch (NumberRangeException e) {
            System.out.println(e.getMessage());

        }

    }
}
