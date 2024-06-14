package com.sh.spring.common.student;

public class SggStudent implements Student{
    @Override
    public void study(int hour) {
        System.out.println(hour + "시간 동안 개미는 뚠뚠~ 오늘도 뚠뚠~ 열심히 일을 하네~");
    }
}
