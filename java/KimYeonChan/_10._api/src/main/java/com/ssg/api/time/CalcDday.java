package com.ssg.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcDday {
    public static void main(String[] args) {
        CalcDday calcDday = new CalcDday();
        calcDday.calcDday(LocalDate.now());
        calcDday.calcDday(LocalDate.of(2025, 3, 27));
        calcDday.calcDday(LocalDate.of(2023, 3, 27));
    }

    public void calcDday(LocalDate dDay) {
        if (dDay.isEqual(LocalDate.now())) {
            System.out.println("D-DAY입니다.");
            return;
        }

        if (dDay.isAfter(LocalDate.now())) {
            System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), dDay) + "일 지났습니다.");
        }
        else {
            System.out.println(ChronoUnit.DAYS.between(dDay, LocalDate.now()) + "일 남았습니다.");
        }
    }
}
