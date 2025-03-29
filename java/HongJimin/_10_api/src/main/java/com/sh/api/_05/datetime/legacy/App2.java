package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *<pre>
 *     java.util.Calendar
 *   - java.util.Date의 개선버젼
 *   - Calendar 객체는 불변객체가 아니어서 값 수정이 가능하다.
 *   - Calendar 월을 표현시에 0 ~ 11로 처리한다. (불편)
 *   - 윤초(UTC세계협정시에 사용하는 세슘원자시계와 태양시사이의 오차를 반영)를 반영하지 못한다.
 *</pre>
 */
public class App2 {
    public static void main(String[] args) {
//        Calendar cal = new Calendar(); //new 연산자 사용 불가
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        //특정 일자로 캘린더객체 생성
        //2024-03-04 12:30:30
        Calendar sometime = new GregorianCalendar(2024, 2, 4, 12, 30, 30); //월만 인덱스 적용!
        System.out.println(sometime);

        //년, 월, 일, 시, 분, 초, getter
        int year = sometime.get(Calendar.YEAR); //원하는 필드를 넣기
        int month = sometime.get(Calendar.MONTH);
        int dayOfMonth = sometime.get(Calendar.DAY_OF_MONTH);
        int hour = sometime.get(Calendar.HOUR_OF_DAY); //24시간 제
        int minute = sometime.get(Calendar.MINUTE);
        int second = sometime.get(Calendar.SECOND);
        int dayOfWeek = sometime.get(Calendar.DAY_OF_WEEK); //일 (1) ~ 토(7)
        int amPm = sometime.get(Calendar.AM_PM); //0 = 오전, 1 = 오후
        System.out.println("year = " + year); //year = 2024
        System.out.println("month = " + (month + 1)); //month = 3
        System.out.println("dayOfMonth = " + dayOfMonth); //dayOfMonth = 4
        System.out.println("hour = " + hour);// hour = 12
        System.out.println("minute = " + minute); //minute = 30
        System.out.println("second = " + second); //second = 30
        System.out.println("dayOfWeek = " + dayOfWeek); //dayOfWeek = 2
        System.out.println("amPm = " + amPm); //amPm = 1

        String weekday = switch (dayOfWeek) {
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> ""; //switch expression에서 default 구문은 필수, break문 안써줘도 값이 하나만 할당됨
        }; //switch expression의 경우, 마지막 세미콜론을 반드시 찍어줌
        System.out.println(weekday); //월
        System.out.println(amPm == 0  ? "오전" : "오후"); //오후

        //Calendar -> Date
        long mills = sometime.getTimeInMillis(); //unix time
        Date date1 = new Date(mills);
        System.out.println(date1);

        //Date -> Calendar
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date1);
        System.out.println(cal2);

        //날짜 차이 (long 타입으로 변환)
        //월(d-5) 화(d-4) 수 (d-3) 목 (d-2) 금(d-1) 토(d-day)
        Calendar today = new GregorianCalendar();
        Calendar thisWeekend = new GregorianCalendar(2024, 3 - 1, 30);

        //(미래long - 과거long) / 1000 / 60 / 60 / 24 -> 일
        double diff = thisWeekend.getTimeInMillis() - today.getTimeInMillis();
        System.out.println(diff); //2.15646312E8 -> 2.15646312 * 10^8
        diff = diff / 1000 / 60 / 60 / 24;
        System.out.println(diff); // 2.495906388888889 일

        diff = Math.ceil(diff); //올림 처리
        System.out.println("주말은 " + (int)diff + "일 남았습니다."); // 주말은 3일 남았습니다.
     }
}
