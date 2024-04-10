package com.sh.thread._02.synchronization.bakery;

public class Baker implements Runnable {
    private  Plate plate;

    public Baker(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            plate.makeBread(i);
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
