package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <pre>
 *     java.util.Calendar
 *     - java.util.Date의 개선버전
 *     - calendar 객체는 불변객체가 아니어서 값 수정이 가능하다.
 *     - Calendar 월을 표현시에 0~11로 처리한다.
 *     - 윤초(UTC에서 사용하는 세슘원자시계와 태양시 사이의 오차를 반영하기 위함)를 반영하지 못한다
 *
 *
 * </pre>
 *
 */
public class App2 {
    public static void main(String[] args) {
//        Calendar cal = new Calendar();  //new 연산자 사용불가
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        //특정일자로 캘린더 객체 생성
        //2024-03-04 12:30:30
        Calendar sometime = new GregorianCalendar(2024,2,4,12,30,10);
        System.out.println(sometime);

        //년,월,일,시,분,초 getter
        int year = sometime.get(Calendar.YEAR);
        int month = sometime.get(Calendar.MONTH);
        int day = sometime.get(Calendar.DAY_OF_MONTH);
        int hour = sometime.get(Calendar.HOUR_OF_DAY);
        int minute = sometime.get(Calendar.MINUTE);
        int second = sometime.get(Calendar.SECOND);
        int dayOfWeek = sometime.get(Calendar.DAY_OF_WEEK);//일(1)~토(7)
        int amPm = sometime.get(Calendar.AM_PM);    //오전(0) 오후(1)

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("dayOfMonth = " + day);
        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);
        System.out.println("second = " + second);

        String weekday = switch(dayOfWeek){
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

        //Calendar -> Date
        long millis = sometime.getTimeInMillis();   //unix time
        Date date1 = new Date(millis);
        System.out.println(date1);

        //Date -> Calendar
        Calendar cal2 = new GregorianCalendar();
        cal2.setTime(date1);
        System.out.println(cal2);

        //날짜 차이 (long 타입으로 변환)
        Calendar today = new GregorianCalendar();
        Calendar thisWeekend = new GregorianCalendar(2024, 3 - 1, 30);

        //(미리long - 과거long) /1000/60/60/24->일
        double diff = thisWeekend.getTimeInMillis() - today.getTimeInMillis();
        System.out.println(diff);
        diff = diff / 100/ 60 / 60 / 24/10;
        System.out.println(diff);   //2.44054039503
        diff = Math.ceil(diff); // 2.xxx ->3

        System.out.println("주말은 " + (int)diff + "일 남았습니다");




    }

}
