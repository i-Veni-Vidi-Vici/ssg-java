package com.ssg.thread.sleep;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SleepTest {
    public static void main(String[] args) {
        SleepTest sleepTest = new SleepTest();
        sleepTest.sendAphorism();
    }

    public void sendAphorism() {
        String[] str = {"계란으로 바위치기",
                        "고기도 먹어본 사람이 많이 먹는다",
                        "고래 싸움에 새우 등 터진다",
                        "고양이한테 생선 맡겼다",
                        "고인 물은 썩는다",
                        "공든 탑이 무너지랴",
                        "구관이 명관이다",
                        "구슬이 서말이라도 꿰어야 보배",
                        "귀신이 곡할 노릇이다",
                        "길고 짧은 것은 대어 봐야 안다"
                        };

        Random rnd = new Random();

        try {
            int random = rnd.nextInt(10);
            ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
            ses.scheduleAtFixedRate(() -> System.out.println(str[random]), 10, 1, TimeUnit.SECONDS);
            Thread.sleep(3000);
            ses.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
