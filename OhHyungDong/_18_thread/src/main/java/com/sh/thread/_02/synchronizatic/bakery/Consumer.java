package com.sh.thread._02.synchronizatic.bakery;

public class Consumer implements Runnable{
    private Plate plate;

    public Consumer(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        for(int i = 0; i<10; i++){
            plate.eatBread();
            try {
                Thread.sleep((long) (Math.random() * 100));
            }catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
