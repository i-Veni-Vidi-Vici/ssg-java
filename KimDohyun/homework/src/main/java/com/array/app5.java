package com.array;

import java.util.Arrays;

public class app5 {
    public static void main(String[] args) {
       String[] Attendance = {
               "홍길동",
               "이순신",
               "유관순",
               "윤봉길",
               "장영실",
               "임꺽정",
               "장보고",
               "이태백",
               "김정희",
               "대조영",
               "김유신",
               "이사부"
       };
        Arrays.sort(Attendance);
        print(Attendance);
    }
    public static void print(String[] arr){
        int cnt = 0;
        for(int i = 1; i <= 2; i++) {
            System.out.println("== "+i+"분단 ==");
            for(int j = 0; j < arr.length/2/2; j++) {
                for(int k = 0; k < 2; k++) {
                    System.out.print(arr[cnt++]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
