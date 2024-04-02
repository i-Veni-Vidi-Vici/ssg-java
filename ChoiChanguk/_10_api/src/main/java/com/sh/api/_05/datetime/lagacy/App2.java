package com.sh.api._05.datetime.lagacy;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <pre>
 * java.util.Calendar
 * - java.util.Date의 개선버전
 * - Calender 객체는 불변객체가 아니어서 값 수정이 가능하다.
 * - Calender 월을 표현시에 0~11로 처리한다.
 * - 윤초(UTC세계협정시에 사용하는 세슘원자시계와 태양시 사이의 오차를 반영하기 위한 개념)를 반영하지 못한다.
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
//        Calendar cal=new Calendar()// new연산자 사용불가
        Calendar cal=Calendar.getInstance();
        //System.out.println(cal);
        //Calendar cal1=new GregorianCalendar();// 이것도 똑같다

        //특정일자로 캘린더객체 생성
        //2024-03-04 12:30:30 // 월은0~11로 보기 때문에 3월은 2로 써야 한다
        Calendar sometime=new GregorianCalendar(2024,02,04,12,30,30);
        System.out.println(sometime);

        // 년, 월, 일, 시, 분, 초 getter
        int year=sometime.get(1);
        int month=sometime.get(2);
        int dayOfMonth=sometime.get(Calendar.DAY_OF_MONTH);
        int hour=sometime.get(Calendar.HOUR);//12시간제, HOUR_OF_DAY= 24시간제
        int min=sometime.get(Calendar.MINUTE);
        int sec= sometime.get(Calendar.SECOND);
        int dayOfWeek=sometime.get(Calendar.DAY_OF_WEEK);//일요일(1)~토(7)
        System.out.printf("year : %d, month : %d, dayofmonth : %d , hour : %d, min : %d, sec : %d\n",year,month+1,dayOfMonth,hour,min,sec);
        System.out.printf("dayOfMonth : %d\n", dayOfMonth);



        String weekday=switch (dayOfWeek)
        {
            case 1->"일";
            case 2->"월";
            case 3->"화";
            case 4->"수";
            case 5->"목";
            case 6->"금";
            case 7->"토";
            default -> "";// switch expression에서 defalut구문은 필수이다
            //break없어도 딱 하나만 처리 됨
        };// switch expression의 경우 마지막에 세미콜론을 반드시 찍는다

        System.out.println(weekday);

        //Calendar -> Date
        long millis=sometime.getTimeInMillis();// unix time
        Date date1=new Date(millis);
        System.out.println("data1 : "+date1);

        //Date -> Calendar
        Calendar cal2=new GregorianCalendar();
        cal2.setTime(date1);
        System.out.println("cal2 : "+cal2);

        // 날짜차이 long타입으로 변환
        Calendar today = new GregorianCalendar();
        Calendar thisWeekend =new GregorianCalendar(2024,3-1,30);

        //(미래 long - 과거 long)나누기 1000하면초 / 60 / 60 /24
        double diff=thisWeekend.getTimeInMillis()-today.getTimeInMillis();
        System.out.println("diff : "+diff);
        diff=diff/1000.0/60.0/60.0/24.0; //초단위/분단위/시단위/일
        System.out.println("diff : "+diff); //
        diff=Math.ceil(diff);
        System.out.printf("주말은 %.0f일 남았습니다 ",diff); //


    }

}
