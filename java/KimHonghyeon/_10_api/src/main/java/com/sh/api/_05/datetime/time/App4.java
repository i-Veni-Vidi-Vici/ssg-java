package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class App4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.of(2024,3,26,14,30,30);
        LocalDateTime future = LocalDateTime.of(2024,3,26,14,30,30);
        ZonedDateTime zonedTime = ZonedDateTime.now();

        System.out.println(now.isAfter(past));
        System.out.println(now.isBefore(future));

    }
}
