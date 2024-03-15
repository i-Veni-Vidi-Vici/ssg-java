package com.sh.multi.dimention;

import java.util.Scanner;

public class q {
    public static void main(String[] args) {
        /**
         * 1234 -> 4321
         * 12345->54321
         * 입력한 숫자를 역순으로 출력하나
         */
        System.out.printf("숫자를 입력 해주세요 : ");
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();

        int out = 0;

        while (true) {

            out = out + in % 10;// ex)1234 -> 4입력 값의 1의 자리를 out에 삽입

            // out에 삽입하고 난 후의 숫자가 1의 자리 숫자면 멈춘다 // 1의자리까지 다 더한 후라서 그 이상 의미가 없다
            if (in <10 ) 
                break;

            out = out * 10;// ex) 4->40

            in= in / 10;//ex) 1234->123

        }
        System.out.printf("출력 output %d", out);
    }
}
