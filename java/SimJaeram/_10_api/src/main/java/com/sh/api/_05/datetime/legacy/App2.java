package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <pre>
 *     java.util.Calendar
 *     - java.util.Date의 개선버전
 *     - Calendar 객체는 불변 객체가 아니어서 값 수정이 가능하다.
*      - Calendar 월을 표현 시 0 ~ 11로 처리한다. // 불편
 *     - 윤초(UTC 세계 협정시에서 사용하는 세슘원자시계와 태양시 사이의 오차를 반영)를 반영하지 못한다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
//        Calendar cal = new Calendar();          // new 연산자 사용불가
//        Calendar cal = Calendar.getInstance();
        Calendar cal = new GregorianCalendar();

        System.out.println(cal);

        // 툭정 일자로 캘린더 객체 생성
        // 2024-03-04 12:30:30
        Calendar sometime = new GregorianCalendar(2024, 2, 4, 12, 30, 30);
        System.out.println(sometime);

        // 년, 월, 일, 시, 분, 초 getter
        int year = sometime.get(Calendar.YEAR);
        int month = sometime.get(Calendar.MONTH);
        int dayOfMonth = sometime.get(Calendar.DAY_OF_MONTH);
        int hour = sometime.get(Calendar.HOUR_OF_DAY);
        int minute = sometime.get(Calendar.MINUTE);
        int second = sometime.get(Calendar.SECOND);
        int dayOfWeek = sometime.get(Calendar.DAY_OF_WEEK);     // 일요일은 1 ~ 토요일은 7
        int amPm = sometime.get(Calendar.AM_PM);                // 오전은 0, 오후는 1

        System.out.println("year = " + year);
        System.out.println("month = " + (month + 1));
        System.out.println("dayOfMonth = " + dayOfMonth);
        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);
        System.out.println("second = " + second);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("amPm = " + amPm);

        // switch expression으로 표현,
        // 마지막 세미콜론을 반드시 작성해야한다.
        // switch문은 default문은 생략 가능하지만, switch expression에서 dafault문은 생략 불가
        String weekday = switch(dayOfWeek) {
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> "";
        };
        System.out.println(weekday);

        System.out.println(amPm == 0 ? "오전" : "오후");

        // Calendar -> Date
        long millis = sometime.getTimeInMillis();       // unix time, Calendar 객체 sometimes를 getTimeInMillis() 메소드 호출하여 밀리초를 리턴 받아 Date 객체로 만듦
        Date date1 = new Date(millis);
        System.out.println(date1);

        // Date -> Calendar
        Calendar cal2 = new GregorianCalendar();        // 생성자로 밀리초를 받아내는 건 없어서, setter 메소드 호출하여
        cal2.setTime(date1);
        System.out.println(cal2);

        // 날짜 차이 // long 타입으로 변환하여 계산한다.
        // 월d-5 화d-4 수d-3 목d-2 금d-1 토(d-day)
        Calendar today = new GregorianCalendar();
        Calendar thisWeekend = new GregorianCalendar(2024, 3 - 1, 30);

        // (미래long 밀리초 - 과거long 밀리초) / 1000 / 60 / 60 / 24 -> 일
        double diff = thisWeekend.getTimeInMillis() - today.getTimeInMillis();
        System.out.println(diff);
        diff = diff / 1000 / 60 / 60 / 24; // 밀리초 차이를 일 차이로 변환하는 연산
        System.out.println(diff);          // 정수 연산하면 2가 나온다. 실수 연산하면 2.4959073842592594
        diff = Math.ceil(diff);            // 2.xxxx -> 3

        System.out.println("주말은 " + (int) diff + "일 남았습니다.");

    }
}
