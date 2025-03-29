package com.ssg.test.operator;

public class App1 {
    public static void main(String[] args){
        int hk=80; int he= 70; int hm= 90;
        int sk=95; int se=80;  int sm= 100;
        int hsum=hk+he+hm;
        double havg=hsum/3;
        int ssum=sk+se+sm;
        double savg=ssum/3;
        System.out.println("홍길동 총점 :" +   hsum + "평균 :"   +    havg +  "합격여부 :" + ((((hk>=40&&he>=40)&&hm>=40)&&havg>=60)?"합격":"불합격"));
        System.out.println("신사임당 총점 :" +   ssum + "평균 :"   +    savg +  "합격여부 :" + ((((sk>=40&&se>=40)&&sm>=40)&&savg>=60)?"합격":"불합격"));
    }
}
