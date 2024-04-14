package com.sh.thread._02.synchronization.backery;

public class Consumer implements Runnable{

    private Plate plate;

    public Consumer(Plate plate) {
        this.plate = plate;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            plate.eatBread();
            try {
                Thread.sleep((long) (Math.random() * 100)); // 와구와구 먹을꺼라서 텀 주기
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
