package com.ssg.thread.sleep;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SleepTest {
    public static void main(String[] args) {
        sendAphorism();
    }

    private static void sendAphorism() {
        String[] proverbs = new String[10];
        proverbs[0] = "물 범벅에 빠진 개구리처럼";
        proverbs[1] = "바늘도둑이 소도둑 된다";
        proverbs[2] = "고생 끝에 낙이 온다";
        proverbs[3] = "가는 날이 장날";
        proverbs[4] = "백지장도 맞들면 낫다";
        proverbs[5] = "고래 싸움에 새우 등 터진다";
        proverbs[6] = "개구리 올챙이 적 생각 못한다";
        proverbs[7] = "산 넘어 산";
        proverbs[8] = "호랑이 굴에 들어가야 호랑이 새끼를 잡는다";
        proverbs[9] = "입으로 된 일이 손으로 된 일보다 더 낫다";

        IntStream stream3 = new Random().ints(0, 10).distinct().limit(10);
        stream3.forEach(index -> {
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(proverbs[index]);
        });
    }
}
