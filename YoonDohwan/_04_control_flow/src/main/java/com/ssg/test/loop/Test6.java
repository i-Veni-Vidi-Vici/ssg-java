package com.ssg.test.loop;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
            String menu = """
                    김밥류 -----------------------------
                    1. 원조김밥===========1500원
                    2. 치즈김밥===========2000원
                    3. 참치김밥===========2300원
                    라면류------------------------------
                    4. 그냥라면===========3000원
                    5. 치즈라면===========3500원
                    6. 짬뽕라면===========4000원
                    분식류------------------------------
                    7. 떡볶이=============2500원
                    8. 순대==============2500원
                    9. 오뎅==============1000원
                    기타-------------------------------
                    10.음료수============1000원
                    """;
        while(true) {
            System.out.println(menu);
            int pick = sc.nextInt();
            char onemore = '0';
            switch(pick){
                case 1: sum+= 1500;break;
                case 2: sum+=2000; break;
                case 3: sum+=2300;break;
                case 4: sum+=3000;break;
                case 5: sum+=3500;break;
                case 6: sum+=4000;break;
                case 7: sum+=2500;break;
                case 8: sum+=2500;break;
                case 9: sum+=1000;break;
                case 10: sum+=1000;break;
                default : return;
            }

        }

    }
}
