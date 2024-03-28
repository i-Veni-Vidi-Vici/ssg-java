package com.ssg.api.time;

import java.awt.event.MouseAdapter;
<<<<<<< HEAD

public class CalcYourDays {
    public static void main(String[] args) {
=======
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalcYourDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long dateLong=sc.nextLong();
        String str=String.valueOf(123);
        System.out.println(str+123);

        Date birth=new Date(dateLong);
        Date today=new Date();
        Calendar calendar=Calendar.getInstance();
        System.out.println("car : "+calendar.getTimeInMillis()/1000);



        System.out.println("today : "+today+" 밀리초 : "+today.getTime()/(1000));
        System.out.println("today : "+birth+" 밀리초 : "+birth.getTime()/(1000));

        System.out.println((today.getTime()-birth.getTime())/(24*60*60*1000));

>>>>>>> a40825df718088cd6bcf7c51356c07f75f3e9ffe

    }
}
