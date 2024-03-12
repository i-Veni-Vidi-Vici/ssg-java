package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args){
        int kor1 = 80;
        int eng1 = 70;
        int math1 = 90;
        int kor2=95;
        int eng2 = 80;
        int math2=100;
        int sum1 = kor1+eng1+math1;
        int sum2 = kor2+eng2+math2;
        double avg1= sum1/3;
        double avg2=sum2/3;
        System.out.printf((kor1 >= 40 && eng1 >= 40 && math1 >= 40) && avg1 >= 60 ? "합격" : "불합격");
        System.out.printf((kor2 >= 40 && eng2 >= 40 && math2 >= 40) && avg2 >= 60 ? "합격" : "불합격");
    }
}
