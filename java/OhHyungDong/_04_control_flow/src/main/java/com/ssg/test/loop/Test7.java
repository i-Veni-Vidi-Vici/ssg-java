package com.ssg.test.loop;

public class Test7 {
    public static void main(String[] args) {
        /**
         * 1 * 8 + 1 = 9 ->
         * 12 * 8 + 2 = 98 -> 12 = 1 * 10 + 2
         * 123 * 8  + 3 = 987 -> 123 = 12 * 10 + 3
         * 1234 * 8 + 4 = 9876 -> 1234 = 123 * 10 + 4
         *
         * 변수값 설정해서 * 10 + i?
         * 그럼 첫번째값은..... 0 * 10 + i 변수 초기화를 0으로 설정시키면되네
         *
         *  마지막 값은 그냥 변수 설정해서 결과 값으로 처리 ?
         */
        int number = 0;
        int calculate = 0;
        for(int i = 1; i<=9; i++)
        {
            number = (number * 10 + i) ;
            calculate = number * 8 + i;
            System.out.println(number + " * 8" + " + " + i + " = " + calculate );
        }

    }

}
