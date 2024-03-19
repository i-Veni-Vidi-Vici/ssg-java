package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        // 임의 변수 선언해서 그 변수로 값 조절해야함
        for(int i =1; i < 10; i++) {
            for(int a = 9; a > i; a--) {
                System.out.print(" ");
            }

            for(int b = 0; b < i; b++) {
                System.out.print(b+1);
            }
            System.out.print(" X 8 + " + i + " = ");

            for(int a = 9; a > 0; a--) {
                System.out.print(a);
                if(a == 10 - i) {
                    break;
                }
            }
            System.out.println();
        }

        // 강사님 코드
//        for(int i = 1; i < 10; i++) {
//            String n = "";
//            for(int j = 1; j <= i; j++){
//                n += String.valueOf(j);
//            }
////            System.out.println(n);
//            String padding = " ".repeat(9 - i);
//            System.out.printf("%s%s x 8 + %d = %s%n", padding, n, i, Integer.parseInt(n) * 8 + i);
//        }
    }
}
