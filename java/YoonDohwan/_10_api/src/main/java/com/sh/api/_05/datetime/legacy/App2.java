package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * java.util.calendar
 * -java.util.date의 개선버젼
 * -calendar 객체는 불변객체가 아니어서 값 수정이 가능하다.
 * -Calendar 월을 표현시에 0~11로 처리한다.(불편)
 * -윤초(UTC세계협정시에서 사용하는 세슘원자시계와 태양시 사이의 오차)를 반영하지 못한다.
 */


public class App2 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        Calendar sometime = new GregorianCalendar(2024,2,4,12,30);
        System.out.println(sometime);

        //년 월,일,시,분,초 getter
        int year = sometime.get(Calendar.YEAR);
        int month=sometime.get(Calendar.MONTH);
        int dayOfMonth=sometime.get(Calendar.DAY_OF_MONTH);
        int hour = sometime.get(Calendar.HOUR);
        int minute = sometime.get(Calendar.MINUTE);
        int second = sometime.get(Calendar.SECOND);
        System.out.println("year = "+year);
        System.out.println("month = "+month);
        System.out.println("dayOfMonth = "+dayOfMonth);
        System.out.println("hour = "+hour);

        //Calendar -> Date
        long millis = sometime.getTimeInMillis();
        Date date1=new Date(millis);
        System.out.println(date1);


        //Date->Calendar
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date1);
        System.out.println(cal2);
        //날짜차이(long 타입으로 변환)
        Calendar today = new GregorianCalendar();
        Calendar thisWeekend = new GregorianCalendar(2024,3-1,30);
        double diff=thisWeekend.getTimeInMillis()-today.getTimeInMillis();
        diff=diff/1000/60/60/24;
        System.out.println(diff);
        diff=Math.ceil(diff);
        System.out.println("주말은 "+(int)diff+"일 남았습니다.");



    }
}
