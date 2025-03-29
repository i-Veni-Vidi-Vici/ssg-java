package com.sh.spring.common.student;

public class SsgStudent implements Student{
    @Override
    public void study(int hour) {
        System.out.println(hour + "시간동안 열심히 코딩합니다.");
    }
}
