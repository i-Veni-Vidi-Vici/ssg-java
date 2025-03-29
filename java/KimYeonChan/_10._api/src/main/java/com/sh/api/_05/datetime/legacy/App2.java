package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * java.util.Calender
 * - java.util.Date 의 개선 버전
 * - Calendar 객체는 불변객체가 아니어서 값 수정이 가능하다.
 * - Calendar 월을 표현시에 0~11로 처리한다. (불편)
 * - 윤초(UTC 세계협정시에 사용하는 세슘원자시께와 태양시 사이의 오차를 반영)를 반영하지 못한다.
 */
public class App2 {
    public static void main(String[] args) {
        // Calendar cal = new Calendar(); 기본 생성자 사용불가
        // Calendar cal = Calendar.getInstance();
        Calendar cal = new GregorianCalendar();
        System.out.println(cal);

        // 특정 일자로 캘런더 객체 생성
        // 2024-03-04 12:30:30
        Calendar sometime = new GregorianCalendar(2024, Calendar.MARCH, 27, 12, 30, 30);
        System.out.println(sometime);

        // 년, 월, 일, 시, 분, 초 getter
        int year = sometime.get(Calendar.YEAR);
        int month = sometime.get(Calendar.MONTH);
        int dayOfMonth = sometime.get(Calendar.DAY_OF_MONTH);
        int hour = sometime.get(Calendar.HOUR);
        int minute = sometime.get(Calendar.MINUTE);
        int second = sometime.get(Calendar.SECOND);
        // int dayOfWeek = sometime.get(Calendar.DAY_OF_MONTH); // 일요일 1, 토요일 7
        String dayOfWeek = switch (sometime.get(Calendar.DAY_OF_WEEK)){
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> ""; // switch expression 에서 default 구문은 필수
        };
        int amPm = sometime.get(Calendar.AM_PM); // 오전 (0), 오후 (1);
        System.out.println(year);
        System.out.println(month);
        System.out.println(dayOfMonth);
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
        System.out.println(dayOfWeek);
        System.out.println(amPm == 0 ? "오전" : "오후");

        // Calendar -> Date
        long millis = sometime.getTimeInMillis(); // unix time
        Date date1 = new Date(millis);
        System.out.println(date1);

        // Date -> Calendar
        Calendar cal2= new GregorianCalendar();
        cal2.setTime((date1));
        System.out.println(cal2);

        // 날짜 차이 (long 타입으로 변환)
        Calendar today = new GregorianCalendar();
        Calendar thisWeekend = new GregorianCalendar(2024, 3 - 1, 30);

        // (미래 long - 과거 long) / 1000 / 60 / 60/ 24 -> 일
        double diff = thisWeekend.getTimeInMillis() - today.getTimeInMillis();
        System.out.println(diff);
        diff = diff / 1000 / 60 / 60 / 24;
        System.out.println(diff);
        diff = Math.ceil(diff);
        System.out.println("주말은 " + (int)diff + "일 남았습니다.");

    }
}
