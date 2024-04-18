package com.ssg.thread.sleep;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SleepTest {
    public static void main(String[] args) {
        sendAphorism();
    }

    private static void sendAphorism(){
        String[] strs = {"1111", "2222", "3333", "4444", "5555", "6666", "7777", "8888", "9999", "0000"};
        Set<Integer> order = new LinkedHashSet<>();
        while (order.size() < 10) {
            order.add((int)(Math.random()*10));
        }

            order.forEach(index ->{
                System.out.println(strs[index]);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

    }
}
