package com.ssg.api.time;
import java.time.LocalDate;

/*
 오늘 날짜를 다음 형식으로 출력하세요.
 */
public class TodayTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        int value = now.getDayOfWeek().getValue();
        String dayOfWeek = switch(value){
            case 1 -> "월";
            case 2 -> "화";
            case 3 -> "수";
            case 4 -> "목";
            case 5 -> "금";
            case 6 -> "토";
            case 7 -> "일";
            default -> "";
        };

        System.out.printf("오늘은 %d년 %s월 %d일 %s요일입니다.",
                now.getYear(),now.getMonthValue(),now.getDayOfMonth(),dayOfWeek);
    }
}
