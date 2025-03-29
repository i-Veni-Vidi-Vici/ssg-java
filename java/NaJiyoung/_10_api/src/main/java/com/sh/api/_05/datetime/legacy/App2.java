package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <pre>
 * java.util.Calendar
 * - java.util.Date의 개선버젼
 * - Calendar 객체는 불변객체가 아니어서 값 수정이 가능하다.
 * - Calendar 월을 표현시에 0 ~ 11로 처리한다. (불편)
 * - 윤초(UTC세계협정시에 사용하는 세슘원자시계와 태양시사이의 오차를 반영)를 반영하지 못한다.
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
//        Calendar cal = new Calendar(); // new 연산자 사용불가
//        Calendar cal = Calendar.getInstance();
        Calendar cal = new GregorianCalendar();
        System.out.println(cal);

        // 특정일자로 캘린더객체 생성
        // 2024-03-04 12:30:30
        Calendar sometime = new GregorianCalendar(2024, 2, 4, 12, 30, 30); // 2월이 아닌 3월이다.
        System.out.println(sometime);

        // 년,월,일,시,분,초 getter
        int year = sometime.get(Calendar.YEAR);
        int month = sometime.get(Calendar.MONTH); // 1월(0) ~ 12월(11)
        int dayOfMonth = sometime.get(Calendar.DAY_OF_MONTH);
        int hour = sometime.get(Calendar.HOUR_OF_DAY);
        int minute = sometime.get(Calendar.MINUTE);
        int second = sometime.get(Calendar.SECOND);
        int dayOfWeek = sometime.get(Calendar.DAY_OF_WEEK); // 일(1) ~ 토(7)
        int amPm = sometime.get(Calendar.AM_PM); // 오전(0), 오후(1)
        System.out.println("year = " + year);
        System.out.println("month = " + (month + 1)); // 1이 더 작게 나오기 때문
        System.out.println("dayOfMonth = " + dayOfMonth);
        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);
        System.out.println("second = " + second);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("amPm = " + amPm);

        String weekday = switch (dayOfWeek) {
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> ""; // switch expression에서 default구문은 필수이다.
        }; // switch expression의 경우 마지막 세미콜론을 반드시 찍는다.
        System.out.println(weekday);
        System.out.println(amPm == 0 ? "오전" : "오후");

        // Calendar -> Date
        long millis = sometime.getTimeInMillis(); // unix time 반환, sometime은 Calendar 객체
        Date date1 = new Date(millis);
        System.out.println(date1);

        // Date -> Calendar
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date1);
        System.out.println(cal2);

        // 날짜차이 (long타입으로 변환)
        // 월(d-5) 화(d-4) 수(d-3) 목(d-2) 금(d-1) 토(d-day)
        Calendar today = new GregorianCalendar();
        Calendar thisWeekend = new GregorianCalendar(2024, 3 - 1, 30);

        // (미래long - 과거long) / 1000 초 / 60 분 / 60 분 / 24 시간 -> 일
        double diff = thisWeekend.getTimeInMillis() - today.getTimeInMillis();
        System.out.println(diff); // 2.1564 -> 21564
        diff = diff / 1000 / 60 / 60 / 24;
        System.out.println(diff); // 2.49594 일
        diff = Math.ceil(diff); // 2.xxx -> 3

        System.out.println("주말은 " + (int) diff + "일 남았습니다.");
    }
}
