package com.ssg.api.time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TodayTest {
    public String print(){
        LocalDate localDate = LocalDate.now();
        char[] ch = {'일','월', '화', '수', '목', '금', '토'};
        int i = localDate.getDayOfWeek().getValue();

        return String.format("오늘은 %d년 %d월 %d일 %s요일 입니다.", localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), ch[i]);
    }
}
