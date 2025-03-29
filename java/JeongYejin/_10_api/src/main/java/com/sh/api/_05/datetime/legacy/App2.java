package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <pre>
 * java.util.Calendar
 * - java.util.Date의 개선버전
 * - Calendar 객체는 불변객체가 아니어서 값 수정이 가능하다
 * - Calendar는 월을 표현할 때 0 ~ 11로 처리한다. (불편)
 * - 윤초(UTC 세계협정시에 사용하는 세슘원자시계와 태양시 사이의 오차를 반영하기 위한 개념)를 반영하지 못한다.
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
        Calendar sometime = new GregorianCalendar(2024, 2, 27, 18, 15, 2);
        System.out.println(sometime);

        int year = sometime.get(Calendar.YEAR);
        int month = sometime.get(Calendar.MONTH);
        int dayOfMonth = sometime.get(Calendar.DAY_OF_MONTH);
        int hour = sometime.get(Calendar.HOUR); // 12시간제
//        int hour = sometime.get(Calendar.HOUR_OF_DAY); // 24시간제
        int minute = sometime.get(Calendar.MINUTE);
        int second = sometime.get(Calendar.SECOND);
        int dayOfWeek = sometime.get(Calendar.DAY_OF_WEEK);
        int amPm = sometime.get(Calendar.AM_PM); // 오전(0), 오후(1)

        System.out.println("year = " + year);
        System.out.println("month = " + (month + 1));
        System.out.println("dayOfMonth = " + dayOfMonth);
        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);
        System.out.println("second = " + second);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("amPm = " + amPm);

        // switch expression
        String weekday = switch (dayOfWeek) {
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> ""; // switch expression에서 default구문은 필수이다.
        }; // ; 주의 !

        String amPm2 = switch (amPm) {
            case 1 -> "오전";
            case 2 -> "오후";
            default -> "";
        };

        System.out.println("weekday = " + weekday);
        System.out.println("amPm2 = " + amPm2);

        // Calendar -> Date
        long millis = sometime.getTimeInMillis();
        Date date1 = new Date(millis);
        System.out.println(date1);

        // Date -> Calendar
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date1);
        System.out.println(cal2);

        // 날짜차이 (long타입으로 변환)
        Calendar today = new GregorianCalendar();
        Calendar thisWeekend = new GregorianCalendar(2024, 3 - 1, 30);

        // (미래long - 과거long) / 1000 / 60 / 60 / 24 -> 일
        double diff = thisWeekend.getTimeInMillis() - today.getTimeInMillis();
        System.out.println(diff); // 2.15651046E8 -> 215651046
        diff = diff / 1000 / 60 / 60 / 24;
        System.out.println(diff); // 2.4959611805555553 일
        diff = Math.ceil(diff); // 2.xxx -> 3

        System.out.println("주말은 " + (int) diff + "일 남았습니다.");

    }
}