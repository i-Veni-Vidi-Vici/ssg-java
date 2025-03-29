package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args) {
        int hong_Kor = 80;
        int hong_Eng = 70;
        int hong_Math = 90;
        int hong_Sum = hong_Kor + hong_Eng + hong_Math;
        double hong_Avg = (double) hong_Sum / 3;

        int shin_Kor = 95;
        int shin_Eng = 80;
        int shin_Math = 100;
        int shin_Sum = shin_Kor + shin_Eng + shin_Math;
        double shin_Avg = (double)shin_Sum / 3;

        System.out.println("Hong-GilDong's Sum: " +hong_Sum + " Average: " + hong_Avg + " Pass/Fail: " +
                (hong_Kor>=40 && hong_Eng >= 40 && hong_Math >= 40 && hong_Avg >=60));
        System.out.println("Shin-SaImDang's Sum: " +shin_Sum + " Average: " + shin_Avg + " Pass/Fail: " +
                (shin_Kor>=40 && shin_Eng >= 40 && shin_Math >= 40 && shin_Avg >=60));
        System.out.println("* Pass/Fail : true means Pass and false means Fail");


    }
}
