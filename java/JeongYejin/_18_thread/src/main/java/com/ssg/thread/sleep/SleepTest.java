package com.ssg.thread.sleep;

import java.util.*;

public class SleepTest {

    public static void main(String[] args) {
        SleepTest sleepTest = new SleepTest();
        System.out.println("피자 열판 쏘겠습니다.");
        sleepTest.sendAphorism();
    }

    void sendAphorism() {
        String[] pizzaSet = new String[]{"어깨 피자", "얼굴 피자", "주름 피자", "웃음꽃 피자", "가슴 피자", "다리 피자", "팔자 피자", "인생 피자", "형편 피자", "허리 피자"};
        Set<Integer> set = new HashSet<>();
        while (set.size() < 10) {
            int i = (int)(Math.random()*10);
            if (set.add(i)) {
                set.add(i);
                System.out.println(pizzaSet[i]);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
